package com.fivechan.forum.context.comment.domain;

import java.util.UUID;

public class Comment {
    private UUID id;
    private UUID topicId;
    private UUID userAuthId;
    private String content;

    public Comment(UUID id, UUID topicId, UUID userAuthId, String content) {
        this.id = id;
        this.topicId = topicId;
        this.userAuthId = userAuthId;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID gettopicId() {
        return topicId;
    }

    public void settopicId(UUID topicId) {
        this.topicId = topicId;
    }

    public UUID getUserAuthId() {
        return userAuthId;
    }

    public void setUserAuthId(UUID userAuthId) {
        this.userAuthId = userAuthId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
