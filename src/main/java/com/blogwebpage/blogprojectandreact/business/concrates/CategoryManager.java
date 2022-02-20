package com.blogwebpage.blogprojectandreact.business.concrates;

import com.blogwebpage.blogprojectandreact.business.abstracts.CategoryService;
import com.blogwebpage.blogprojectandreact.business.dtos.CategoryGetDto;
import com.blogwebpage.blogprojectandreact.business.dtos.CategoryListDto;
import com.blogwebpage.blogprojectandreact.business.request.CreateCategoryRequest;
import com.blogwebpage.blogprojectandreact.business.request.DeleteCategoryRequest;
import com.blogwebpage.blogprojectandreact.business.request.UpdateCategoryRequest;
import com.blogwebpage.blogprojectandreact.core.mapping.ModelMapperService;
import com.blogwebpage.blogprojectandreact.core.result.*;
import com.blogwebpage.blogprojectandreact.dataAccess.abstracts.CategoryDao;
import com.blogwebpage.blogprojectandreact.entities.concrates.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryManager implements CategoryService {

    private CategoryDao categoryDao;
    private ModelMapperService modelMapperService;

    @Autowired
    public CategoryManager(CategoryDao categoryDao, ModelMapperService modelMapperService) {
        this.categoryDao = categoryDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateCategoryRequest createCategoryRequest) {
        Category response = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);
        if (this.checkIfCategoryName(response.getCategoryName())) {
            return new ErrorResult(" isimler Aynı Olamaz");
        }
        this.categoryDao.save(response);
        return new SuccessResult(response.getCategoryName() + " isimli Category Eklendi");

    }

    @Override
    public DataResult<List<CategoryListDto>> getAll() {
        List<Category> response = this.categoryDao.findAll();
        List<CategoryListDto> result = response
                .stream()
                .map(category -> this.modelMapperService.forDto().map(category, CategoryListDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<CategoryListDto>>(result, "Kategoriler Listelendi.");
    }

    @Override
    public DataResult<CategoryGetDto> getById(int categoryId) {
        if (this.checkIfCategoryId(categoryId)) {
            return new ErrorDataResult<CategoryGetDto>(categoryId + " No'lu Kategori Veri tabanında bulunamadı!");
        }
        Category response = this.categoryDao.getById(categoryId);
        CategoryGetDto result = this.modelMapperService.forDto().map(response, CategoryGetDto.class);
        return new SuccessDataResult<CategoryGetDto>(result, categoryId + " No'lu Kategori Getirilmiştir");
    }

    @Override
    public DataResult<CategoryGetDto> getByCategoryName(String categoryName) {
        Category response = this.categoryDao.getByCategoryName(categoryName);
        if (response == null) {
            return new ErrorDataResult<CategoryGetDto>(categoryName + " İsime Ait Kategori Veri tabanında bulunamadı!");
        }
        CategoryGetDto result = this.modelMapperService.forDto().map(response, CategoryGetDto.class);
        return new SuccessDataResult<CategoryGetDto>(result, categoryName + " İsime Ait Kategori Getirilmiştir");
    }

    @Override
    public Result update(UpdateCategoryRequest updateCategoryRequest) {
        Category response = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
        if (this.checkIfCategoryName(response.getCategoryName())) {
            return new ErrorResult("isimler Aynı Olamaz");
        } else if (this.checkIfCategoryId(response.getCategoryId())) {
            return new ErrorResult(response.getCategoryId() + " No'lu Id Veri Tabanında bulunamadı!");
        }
        this.categoryDao.save(response);
        return new SuccessResult(response.getCategoryName() + " isimli Category Güncellendi");

    }

    @Override
    public Result delete(DeleteCategoryRequest deleteCategoryRequest) {
        Category response = this.modelMapperService.forRequest().map(deleteCategoryRequest, Category.class);
        if (this.checkIfCategoryId(response.getCategoryId())) {
            return new ErrorResult(response.getCategoryId() + " No'lu Id Veri Tabanında bulunamadı!");
        }
        this.categoryDao.delete(response);
        return new SuccessResult("Category Silindi");
    }

    private boolean checkIfCategoryName(String categoryName) {
        return this.categoryDao.existsByCategoryName(categoryName);

    }

    private boolean checkIfCategoryId(int categoryId) {
        return !this.categoryDao.existsByCategoryId(categoryId);


    }
}
