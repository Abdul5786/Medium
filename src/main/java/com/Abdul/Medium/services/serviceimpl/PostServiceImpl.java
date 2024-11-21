package com.Abdul.Medium.services.serviceimpl;

import com.Abdul.Medium.config.ModelMapperConfig;
import com.Abdul.Medium.entities.Category;
import com.Abdul.Medium.entities.Post;
import com.Abdul.Medium.entities.User;
import com.Abdul.Medium.exceptions.ResourceNoutFoundException;
import com.Abdul.Medium.payloads.PostDto;
import com.Abdul.Medium.repositories.CategoryRepo;
import com.Abdul.Medium.repositories.PostRepo;
import com.Abdul.Medium.repositories.UserRepo;
import com.Abdul.Medium.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService
{
    @Autowired
     PostRepo postRepo;
    @Autowired
    ModelMapperConfig modelmapper;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    UserRepo userRepo;

    @Autowired
    UserServiceImpl userService;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId)
    {
        User user1 = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNoutFoundException("user", "userId", +userId));
//        Category category1 = this.categoryRepo.findById(catId).orElseThrow(() -> new ResourceNoutFoundException("category", "categoryId", +catId));
//        System.out.println(category1);
        Post post = this.dtoToPost(postDto);
//        post.setCategory(category1);
        post.setUser(user1);
        post.setAddedDate(new Date());
        Post save = postRepo.save(post);
        return this.postTodto(save);
    }


    @Override
    public PostDto updatePost(PostDto postDto, Integer postId)
    {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNoutFoundException("post", "postId", postId));
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getContent());
        Post save = postRepo.save(post);
        return postTodto(save);
    }

    @Override
    public void deletePost(Integer posId)
    {
        Post post = postRepo.findById(posId).orElseThrow(() -> new ResourceNoutFoundException("post", "postId", posId));
        postRepo.delete(post);
    }

    @Override
    public List<PostDto> getAllPost()
    {
        List<Post> allpost = postRepo.findAll();
        return  allpost.stream().map(e->this.postTodto(e)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Integer postId)
    {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNoutFoundException("post", "postId", +postId));
        return postTodto(post);
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId)
    {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNoutFoundException("user", "userId", +userId));
        List<Post> postByUser = this.postRepo.findByUser(user);
        List<PostDto> postList = postByUser.stream().map(post -> this.postTodto(post)).collect(Collectors.toList());
        return postList;
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId)
    {

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNoutFoundException("category", "categoryId", +categoryId));
        List<Post> listPost = postRepo.findByCategory(category);
        return  listPost.stream().map(e->this.postTodto(e)).collect(Collectors.toList());

    }

    @Override
    public String likedPost(Integer postId, Integer userId)
    {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNoutFoundException("post", "postId", +postId));
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNoutFoundException("user", "userId", +userId));

        // Check if the user has already liked the post
        if(post.getLikedBy().contains(user))
        {
            // If the user has liked the post, unlike it
            post.removeLike(user);
            post.decrementLikeCount();
            postRepo.save(post);
            return "unliked";
        }

        else
        {
            // If the user has not liked the post, like it
            post.addLike(user);
            post.incrementLikeCount();
            postRepo.save(post);
            return "liked";
        }

    }


    @Override
    public String getTotalLikesOfPost(Integer postId)
    {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNoutFoundException("post", "postId", +postId));
        int size = post.getLikedBy().size();
        return "total likes on post " +size;
    }

    @Override
    public Set<User> getListOfLikesByUsers(Integer postId) {
        Set<User> usersLikesOnPost = postRepo.findUsersLikesOnPost(postId);
        if (usersLikesOnPost != null && !usersLikesOnPost.isEmpty()) {
            return usersLikesOnPost;
        }
        return Collections.emptySet();  // Return an empty set if no likes or if null
    }
    public Post dtoToPost(PostDto postDto)
      {
          return  this.modelmapper.modelMapper().map(postDto, Post.class);
      }
      public PostDto postTodto(Post post)
      {
          return this.modelmapper.modelMapper().map(post,PostDto.class);
      }




}



