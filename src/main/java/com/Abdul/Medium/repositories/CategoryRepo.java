package com.Abdul.Medium.repositories;

import com.Abdul.Medium.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer>
{

}
