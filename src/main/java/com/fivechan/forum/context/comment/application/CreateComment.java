package com.fivechan.forum.context.comment.application;

import com.fivechan.forum.context.comment.domain.Comment;
import com.fivechan.forum.context.comment.domain.CommentRepository;

import java.util.UUID;

public class CreateComment {
    private final CommentRepository commentRepository;

    public CreateComment(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void run(UUID id, UUID postId, UUID userAuthId, String content) {
        Comment comment = new Comment(id, postId, userAuthId, content);
        this.commentRepository.save(comment);
    }
}
