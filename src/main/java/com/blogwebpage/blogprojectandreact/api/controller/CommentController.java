package com.blogwebpage.blogprojectandreact.api.controller;

import com.blogwebpage.blogprojectandreact.business.abstracts.CommentService;
import com.blogwebpage.blogprojectandreact.business.dtos.CommentGetDto;
import com.blogwebpage.blogprojectandreact.business.dtos.CommentListDto;
import com.blogwebpage.blogprojectandreact.business.request.CreateCommentRequest;
import com.blogwebpage.blogprojectandreact.business.request.DeleteCommentRequest;
import com.blogwebpage.blogprojectandreact.business.request.UpdateCommentRequest;
import com.blogwebpage.blogprojectandreact.core.result.DataResult;
import com.blogwebpage.blogprojectandreact.core.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    Result add(@RequestBody CreateCommentRequest createCommentRequest) {
        return this.commentService.add(createCommentRequest);
    }

    @GetMapping("/getAll")
    DataResult<List<CommentListDto>> getAll() {
        return this.commentService.getAll();
    }

    @GetMapping("/getById")
    DataResult<CommentGetDto> getById(@RequestParam int commentId) {
        return this.commentService.getById(commentId);
    }

    @GetMapping("/getByCommentTitle")
    DataResult<List<CommentListDto>> getByCommentTitle(@RequestParam String commentTitle) {
        return this.commentService.getByCommentTitle(commentTitle);
    }

    @PostMapping("/update")
    Result update(@RequestBody UpdateCommentRequest updateCommentRequest) {
        return this.commentService.update(updateCommentRequest);
    }

    @DeleteMapping("/delete")
    Result delete(@RequestBody DeleteCommentRequest deleteCommentRequest) {
        return this.commentService.delete(deleteCommentRequest);
    }
}
