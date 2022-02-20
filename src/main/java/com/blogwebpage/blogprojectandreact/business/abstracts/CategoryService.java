package com.blogwebpage.blogprojectandreact.business.abstracts;

import com.blogwebpage.blogprojectandreact.business.dtos.CategoryGetDto;
import com.blogwebpage.blogprojectandreact.business.dtos.CategoryListDto;
import com.blogwebpage.blogprojectandreact.business.request.CreateCategoryRequest;
import com.blogwebpage.blogprojectandreact.business.request.DeleteCategoryRequest;
import com.blogwebpage.blogprojectandreact.business.request.UpdateCategoryRequest;
import com.blogwebpage.blogprojectandreact.core.result.DataResult;
import com.blogwebpage.blogprojectandreact.core.result.Result;
import com.blogwebpage.blogprojectandreact.entities.concrates.Category;

import java.util.List;

public interface CategoryService {

    Result add(CreateCategoryRequest createCategoryRequest);

    DataResult<List<CategoryListDto>> getAll();

    DataResult<CategoryGetDto> getById(int categoryId);

    DataResult<CategoryGetDto> getByCategoryName(String categoryName);

    Result update(UpdateCategoryRequest updateCategoryRequest);

    Result delete(DeleteCategoryRequest deleteCategoryRequest);


}

//crud Opereation
//add
//getall,getById,GetByName
//update
//delete
