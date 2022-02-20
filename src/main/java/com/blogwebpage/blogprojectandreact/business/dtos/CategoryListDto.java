package com.blogwebpage.blogprojectandreact.business.dtos;

import com.blogwebpage.blogprojectandreact.entities.concrates.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryListDto {


    private int categoryId;
    private String categoryName;
}
