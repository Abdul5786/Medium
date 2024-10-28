package com.Abdul.Medium.payloads;

import com.Abdul.Medium.entities.Category;
import com.Abdul.Medium.entities.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Data
public class PostDto
{
    private int postId;
    private String title;
    private String content;
    private String image;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;

}
