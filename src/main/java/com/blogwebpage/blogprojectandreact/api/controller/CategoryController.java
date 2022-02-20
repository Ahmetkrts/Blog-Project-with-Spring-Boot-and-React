package com.blogwebpage.blogprojectandreact.api.controller;

import com.blogwebpage.blogprojectandreact.business.abstracts.CategoryService;
import com.blogwebpage.blogprojectandreact.business.dtos.CategoryGetDto;
import com.blogwebpage.blogprojectandreact.business.dtos.CategoryListDto;
import com.blogwebpage.blogprojectandreact.business.request.CreateCategoryRequest;
import com.blogwebpage.blogprojectandreact.business.request.DeleteCategoryRequest;
import com.blogwebpage.blogprojectandreact.business.request.UpdateCategoryRequest;
import com.blogwebpage.blogprojectandreact.core.result.DataResult;
import com.blogwebpage.blogprojectandreact.core.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    Result add(@RequestBody CreateCategoryRequest createCategoryRequest) {
        return this.categoryService.add(createCategoryRequest);
    }

    @GetMapping("/getAll")
    DataResult<List<CategoryListDto>> getAll() {
        return this.categoryService.getAll();
    }

    @GetMapping("/getById")
    DataResult<CategoryGetDto> getById(@RequestParam int categoryId) {
        return this.categoryService.getById(categoryId);
    }

    @GetMapping("/getByCategoryName")
    DataResult<CategoryGetDto> getByCategoryName(@RequestParam String categoryName) {
        return this.categoryService.getByCategoryName(categoryName);
    }

    @PostMapping("/update")
    Result update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return this.categoryService.update(updateCategoryRequest);
    }

    @DeleteMapping("/delete")
    Result delete(@RequestBody DeleteCategoryRequest deleteCategoryRequest) {
        return this.categoryService.delete(deleteCategoryRequest);
    }
}
