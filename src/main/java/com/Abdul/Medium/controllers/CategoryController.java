package com.Abdul.Medium.controllers;

import com.Abdul.Medium.payloads.ApiResponse;
import com.Abdul.Medium.payloads.CategoryDto;
import com.Abdul.Medium.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/creat_category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto cat)
    {
        CategoryDto catDto = categoryService.createCategory(cat);
        return new ResponseEntity<>(catDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "update_category/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto catDto, @PathVariable Integer catId)
    {
        CategoryDto updatedCatDto = categoryService.updateCategory(catDto, catId);
        return ResponseEntity.ok(updatedCatDto);
    }

    @GetMapping(value = ("/getall_categories"))
   public ResponseEntity<List<CategoryDto>> getAllCategories()
   {
       List<CategoryDto> allCategories = categoryService.getAllCategories();
       return ResponseEntity.ok(allCategories);
   }

   @DeleteMapping(value = "delete/{catId}")
   public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId)
   {
       categoryService.deleteCategory(catId);
       return  new ResponseEntity<ApiResponse>( new ApiResponse("gya khatam",true),HttpStatus.OK);
   }

      @GetMapping(value = "/getTitles")
     public ResponseEntity<List<String>> getAllCategoriesTitles()
     {
         List<String> allTitle = categoryService.getAllTitle();
         return ResponseEntity.ok(allTitle);
     }


}
