package com.blogwebpage.blogprojectandreact.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequest {

    private String commentTitle;
    private String commentContent;
}