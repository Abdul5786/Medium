package com.Abdul.Medium.payloads;

import com.Abdul.Medium.entities.Comments;
import com.Abdul.Medium.entities.Post;
import com.Abdul.Medium.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto
{
    private int cid;
    private String comment;
    private UserDto user;
    private PostDto post;
}


