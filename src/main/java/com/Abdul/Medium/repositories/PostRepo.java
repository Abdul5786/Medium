package com.Abdul.Medium.repositories;

import com.Abdul.Medium.entities.Category;
import com.Abdul.Medium.entities.Post;
import com.Abdul.Medium.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;


public interface PostRepo extends JpaRepository<Post,Integer>
{

        List<Post> findByUser(User user);

        List<Post> findByCategory(Category category);

    @Query(value = "SELECT u FROM User u JOIN u.likedPosts pl WHERE pl.id = :postId", nativeQuery = true)
    Set<User> findUsersLikesOnPost(@Param("postId") Integer postId);

}

