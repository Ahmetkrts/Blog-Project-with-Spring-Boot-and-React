package com.blogwebpage.blogprojectandreact.dataAccess.abstracts;

import com.blogwebpage.blogprojectandreact.entities.concrates.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {
    boolean existsByCommentId(int commentId);

    List<Comment> findByCommentTitleIgnoreCaseIsContaining(String commentTitle);
}
