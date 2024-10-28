package com.Abdul.Medium.repositories;

import com.Abdul.Medium.entities.Category;
import com.Abdul.Medium.entities.Post;
import com.Abdul.Medium.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


public interface PostRepo extends JpaRepository<Post,Integer>
{

        List<Post> findByUser(User user);

        List<Post> findByCategory(Category category);
}
