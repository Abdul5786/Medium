package com.Abdul.Medium.repositories;

import com.Abdul.Medium.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comments,Integer>
{

}
