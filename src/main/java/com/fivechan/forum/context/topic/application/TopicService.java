package com.fivechan.forum.context.topic.application;

import com.fivechan.forum.context.topic.domain.Topic;
import com.fivechan.forum.context.topic.domain.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TopicService {
    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public void createTopic(UUID id, UUID userId, String title, String content) {
        this.topicRepository.save(new Topic(id, userId, title, content));
    }
}
