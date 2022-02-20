package com.blogwebpage.blogprojectandreact.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentListDto {

    private int commentId;
    private String commentTitle;
    private String commentContent;
}