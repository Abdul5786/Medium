package com.Abdul.Medium.controllers;

import com.Abdul.Medium.payloads.CommentsDto;
import com.Abdul.Medium.repositories.CommentRepo;
import com.Abdul.Medium.services.CommentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentsController
{

    @Autowired
    CommentService commentService;


     @PostMapping(value = "/add/user/{userId}/post/{postId}")
    public ResponseEntity<CommentsDto> addComments(@RequestBody CommentsDto cm, @PathVariable Integer userId,@PathVariable Integer postId)
    {
        CommentsDto commentsDto = commentService.addComment(cm, userId, postId);
        return ResponseEntity.ok(commentsDto);
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<List<CommentsDto>> getAllCom()
    {
        List<CommentsDto> allComments = commentService.getAllComments();
        return ResponseEntity.ok(allComments);
    }

    @GetMapping(value = "/getCommentsbyUser/{userId}")
    public ResponseEntity<List<String>> getCommentsByUser(@PathVariable Integer userId)
    {
        List<String> commentByUser = commentService.getCommentByUser(userId);
        return ResponseEntity.ok(commentByUser);
    }
}
