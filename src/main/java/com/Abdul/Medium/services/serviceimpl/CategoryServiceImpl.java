package com.Abdul.Medium.services.serviceimpl;

import com.Abdul.Medium.config.ModelMapperConfig;
import com.Abdul.Medium.entities.Category;
import com.Abdul.Medium.exceptions.ResourceNoutFoundException;
import com.Abdul.Medium.payloads.CategoryDto;
import com.Abdul.Medium.repositories.CategoryRepo;
import com.Abdul.Medium.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService
{

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ModelMapperConfig modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto)
    {
        Category category = this.dtoToCategory(categoryDto);
        Category save = categoryRepo.save(category);
        return this.categoryToCategoryDto(save);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer catId)
    {
        Category category= categoryRepo.findById(catId).orElseThrow(() -> new ResourceNoutFoundException("category", "categordId", catId));
        category.setDescription(categoryDto.getDescription());
        category.setTitle(categoryDto.getTitle());
        Category save = categoryRepo.save(category);
        return this.categoryToCategoryDto(save);
    }

    @Override
    public CategoryDto getCategorById(Integer catId)
    {
        Category category = categoryRepo.findById(catId).orElseThrow(() -> new ResourceNoutFoundException("catgory", "category", catId));
        return this.categoryToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories()
    {
        List<Category> allCategories = categoryRepo.findAll();
        List<String> collect = allCategories.stream().map(c -> c.getTitle()).collect(Collectors.toList());
        List<CategoryDto> categoriesList = allCategories.stream().map(c -> this.categoryToCategoryDto(c)).collect(Collectors.toList());

        return  categoriesList;
    }

    @Override
    public void deleteCategory(Integer catId)
    {
        categoryRepo.deleteById(catId);
    }

    @Override
    public List<String> getAllTitle()
    {
        List<Category> titlesList = categoryRepo.findAll();
        List<String> listOfTitles = titlesList.stream().map(t -> t.getTitle()).collect(Collectors.toList());
        return listOfTitles;

    }

    public Category dtoToCategory(CategoryDto catDto)
    {
        return this.modelMapper.modelMapper().map(catDto,Category.class);
    }
    public  CategoryDto categoryToCategoryDto(Category cat)
    {
        return  this.modelMapper.modelMapper().map(cat,CategoryDto.class);
    }


}

