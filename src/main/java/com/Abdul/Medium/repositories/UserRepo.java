package com.Abdul.Medium.repositories;

import com.Abdul.Medium.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer>
{

}
