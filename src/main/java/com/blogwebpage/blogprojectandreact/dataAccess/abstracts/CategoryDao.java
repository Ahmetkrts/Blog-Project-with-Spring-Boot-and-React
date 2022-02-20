package com.blogwebpage.blogprojectandreact.dataAccess.abstracts;

import com.blogwebpage.blogprojectandreact.entities.concrates.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    boolean existsByCategoryName(String categoryName);

    Category getByCategoryName(String categoryName);

    boolean existsByCategoryId(int categoryId);
}
