package com.blogwebpage.blogprojectandreact.business.abstracts;

import com.blogwebpage.blogprojectandreact.business.dtos.CommentGetDto;
import com.blogwebpage.blogprojectandreact.business.dtos.CommentListDto;
import com.blogwebpage.blogprojectandreact.business.request.CreateCommentRequest;
import com.blogwebpage.blogprojectandreact.business.request.DeleteCommentRequest;
import com.blogwebpage.blogprojectandreact.business.request.UpdateCommentRequest;
import com.blogwebpage.blogprojectandreact.core.result.DataResult;
import com.blogwebpage.blogprojectandreact.core.result.Result;

import java.util.List;

public interface CommentService {

    Result add(CreateCommentRequest createCommentRequest);

    DataResult<List<CommentListDto>> getAll();

    DataResult<CommentGetDto> getById(int commentId);

    DataResult<List<CommentListDto>> getByCommentTitle(String commentTitle);

    Result update(UpdateCommentRequest updateCommentRequest);

    Result delete(DeleteCommentRequest deleteCommentRequest);


}

//crud Opereation
//add
//getall,getById,GetByName
//update
//delete
