package com.Abdul.Medium.services.serviceimpl;

import com.Abdul.Medium.config.ModelMapperConfig;
import com.Abdul.Medium.entities.Comments;
import com.Abdul.Medium.entities.Post;
import com.Abdul.Medium.entities.User;
import com.Abdul.Medium.exceptions.ResourceNoutFoundException;
import com.Abdul.Medium.payloads.CommentsDto;
import com.Abdul.Medium.repositories.CommentRepo;
import com.Abdul.Medium.repositories.PostRepo;
import com.Abdul.Medium.repositories.UserRepo;
import com.Abdul.Medium.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService
{

    @Autowired
    ModelMapperConfig modelmapper;

    @Autowired
    UserRepo userRepo;

    @Autowired
    PostRepo postRepo;



    @Autowired
    CommentRepo  commentRepo;


    @Override
    public CommentsDto addComment(CommentsDto commentsDto, Integer userId, Integer postId)
    {
        //Comments comment = this.modelmapper.modelMapper().map(commentsDto, Comments.class);
        Comments comment = this.dtoToComments(commentsDto);
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNoutFoundException("usernotFound ", " withuserId", +userId));
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNoutFoundException("post", "postId", +postId));
        comment.setUser(user);
        comment.setPost(post);
        commentRepo.save(comment);
        return this.commentsToDto(comment);
    }

    @Override
    public List<CommentsDto> getAllComments()
    {
        List<Comments> all = commentRepo.findAll();
        List<CommentsDto> allcoms = all.stream().map(c -> this.commentsToDto(c)).collect(Collectors.toList());
        return allcoms;
    }

    @Override
    public List<String> getCommentByUser(Integer userId)
    {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNoutFoundException("user", "id", +userId));
        List<Comments> comments = user.getComments();
        List<String> com = comments.stream().map(c -> c.getComment()).collect(Collectors.toList());
        return com;

    }


    public Comments dtoToComments(CommentsDto commentsDto)
    {
        return this.modelmapper.modelMapper().map(commentsDto,Comments.class);
    }

    public CommentsDto commentsToDto(Comments comments)
    {
        return this.modelmapper.modelMapper().map(comments,CommentsDto.class);
    }
}

