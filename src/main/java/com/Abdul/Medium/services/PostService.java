package com.Abdul.Medium.services;

import com.Abdul.Medium.payloads.PostDto;

import java.util.List;

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




}
