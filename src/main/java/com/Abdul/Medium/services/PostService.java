package com.Abdul.Medium.services;

import com.Abdul.Medium.entities.User;
import com.Abdul.Medium.payloads.PostDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface PostService
{

    // create post
    PostDto createPost(PostDto postDto,Integer userId, Integer catId);
    //update
    PostDto updatePost(PostDto postDto,Integer postId);
    // delete post
    void deletePost(Integer posId);
   //
    List<PostDto> getAllPost();

    // get single post
    PostDto getPostById(Integer postId);

    List<PostDto> getPostByUser(Integer userId);

    List<PostDto> getPostByCategory(Integer categoryId);

    public String likedPost(Integer postId, Integer userId);

    public String unLikePost(Integer postId,Integer userId);

    public String  getTotalLikesOfPost(Integer postId);

    public ResponseEntity<Set<User>> getListOfLikesByUsers(Integer postId);


}
