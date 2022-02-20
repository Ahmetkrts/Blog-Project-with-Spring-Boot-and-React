package com.blogwebpage.blogprojectandreact.business.concrates;

import com.blogwebpage.blogprojectandreact.business.abstracts.CommentService;
import com.blogwebpage.blogprojectandreact.business.dtos.CommentGetDto;
import com.blogwebpage.blogprojectandreact.business.dtos.CommentListDto;
import com.blogwebpage.blogprojectandreact.business.request.CreateCommentRequest;
import com.blogwebpage.blogprojectandreact.business.request.DeleteCommentRequest;
import com.blogwebpage.blogprojectandreact.business.request.UpdateCommentRequest;
import com.blogwebpage.blogprojectandreact.core.mapping.ModelMapperService;
import com.blogwebpage.blogprojectandreact.core.result.*;
import com.blogwebpage.blogprojectandreact.dataAccess.abstracts.CommentDao;
import com.blogwebpage.blogprojectandreact.entities.concrates.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentManager implements CommentService {
    private CommentDao commentDao;
    private ModelMapperService modelMapperService;

    @Autowired
    public CommentManager(CommentDao commentDao, ModelMapperService modelMapperService) {
        this.commentDao = commentDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateCommentRequest createCommentRequest) {
        Comment response = this.modelMapperService.forRequest().map(createCommentRequest, Comment.class);
        this.commentDao.save(response);
        return new SuccessResult(createCommentRequest.getCommentTitle() + " Yorumu Eklendi");

    }

    @Override
    public DataResult<List<CommentListDto>> getAll() {
        List<Comment> response = this.commentDao.findAll();
        List<CommentListDto> result = response
                .stream()
                .map(comment -> this.modelMapperService.forDto().map(comment, CommentListDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<CommentListDto>>(result, "Yorumlar Listelendi");
    }

    @Override
    public DataResult<CommentGetDto> getById(int commentId) {
        if (this.checkifCommentId(commentId))
            return new ErrorDataResult<CommentGetDto>(commentId + " No'lu Yorum Veri Tabanında Bulunamadı");
        Comment response = this.commentDao.getById(commentId);
        CommentGetDto result = this.modelMapperService.forDto().map(response, CommentGetDto.class);

        return new SuccessDataResult<CommentGetDto>(result, commentId + " No'lu Yorum Getirildi");
    }

    @Override
    public DataResult<List<CommentListDto>> getByCommentTitle(String commentTitle) {
        List<Comment> response = this.commentDao.findByCommentTitleIgnoreCaseIsContaining(commentTitle);
        List<CommentListDto> result = response.stream().map(comment -> this.modelMapperService.forDto().map(comment, CommentListDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<CommentListDto>>(result, commentTitle + " Aramasında "+result.size()+" Kayıt Bulundu.");
    }

    @Override
    public Result update(UpdateCommentRequest updateCommentRequest) {
        Comment result = this.modelMapperService.forRequest().map(updateCommentRequest, Comment.class);
        this.commentDao.save(result);

        return new SuccessResult("Yorum Güncellendi.");
    }

    @Override
    public Result delete(DeleteCommentRequest deleteCommentRequest) {
        Comment result = this.modelMapperService.forRequest().map(deleteCommentRequest, Comment.class);
        this.commentDao.delete(result);

        return new SuccessResult(deleteCommentRequest.getCommentId()+" No'lu Yorum Silindi.");
    }

    private boolean checkifCommentId(int commetntId) {
        return !this.commentDao.existsByCommentId(commetntId);
    }
}
