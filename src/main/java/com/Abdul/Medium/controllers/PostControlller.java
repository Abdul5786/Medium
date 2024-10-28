package com.Abdul.Medium.controllers;

import com.Abdul.Medium.payloads.CategoryDto;
import com.Abdul.Medium.payloads.PostDto;
import com.Abdul.Medium.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostControlller
{
    @Autowired
      PostService postService;

    // create post
    @PostMapping(value = "/createpost/user/{userId}/category/{catId}")
     public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable  Integer userId, @PathVariable Integer catId)
     {
         PostDto post = postService.createPost(postDto, userId, catId);
         System.out.println(post);
         return  new ResponseEntity<>(post, HttpStatus.CREATED);
     }

     // get all post
     @GetMapping(value = "/getpost")
     public ResponseEntity<List<PostDto>>  getAllPost()
     {
         List<PostDto> allPost = postService.getAllPost();
         return ResponseEntity.ok(allPost);
     }

// get post by id
     @GetMapping(value= "/getPost/{postId}")
      public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
      {
          PostDto postById = postService.getPostById(postId);
          return ResponseEntity.ok(postById);
      }

        // get post by category
      @GetMapping(value="getPostByCat/{catId}")
      public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer catId)
      {
          List<PostDto> postByCategory = postService.getPostByCategory(catId);
          return ResponseEntity.ok(postByCategory);
      }

       // get post by user
       @GetMapping(value = "getPostByUser/{userId}")
      public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId)
       {
          List<PostDto> postByUser = postService.getPostByUser(userId);
          return ResponseEntity.ok(postByUser);
      }

     // update post

    @PutMapping(value = "/update/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto ,@PathVariable Integer postId)
    {
        PostDto UpdatedPost= postService.updatePost(postDto, postId);
        return ResponseEntity.ok(UpdatedPost);
    }


}
