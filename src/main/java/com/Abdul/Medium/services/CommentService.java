package com.Abdul.Medium.services;

import com.Abdul.Medium.payloads.CommentsDto;

import java.util.List;

public interface CommentService
{
    CommentsDto addComment(CommentsDto commentsDto,Integer userId,Integer PostId);
    List<CommentsDto> getAllComments();

    List<String> getCommentByUser(Integer userId);



}
