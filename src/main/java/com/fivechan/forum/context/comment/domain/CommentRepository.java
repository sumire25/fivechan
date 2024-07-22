package com.fivechan.forum.context.comment.domain;

import java.util.UUID;

public interface CommentRepository {
    void save(Comment comment);
    Comment findById(UUID id);
    void deleteById(UUID id);
    void updateById(UUID id, Comment comment);
}
