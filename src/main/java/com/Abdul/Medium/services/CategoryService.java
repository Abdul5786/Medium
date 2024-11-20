package com.Abdul.Medium.services;


import com.Abdul.Medium.config.ModelMapperConfig;
import com.Abdul.Medium.entities.Category;
import com.Abdul.Medium.exceptions.ResourceNoutFoundException;
import com.Abdul.Medium.payloads.CategoryDto;
import com.Abdul.Medium.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public interface CategoryService
{
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto,Integer catId);
    CategoryDto getCategorById(Integer catId);
    List<CategoryDto> getAllCategories();
    void deleteCategory(Integer catId);
    List<String> getAllTitle();

    List<CategoryDto> getCategoriesByName(String categoryByName);




}
