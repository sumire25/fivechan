package com.fivechan.forum.apps.backend.controllers.topic;

import com.fivechan.forum.context.topic.application.TopicService;
import com.fivechan.forum.context.topic.domain.TopicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/topic")
public class TopicController {
    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public  void createTopic(@RequestBody TopicDTO topic) {
        UUID id = UUID.randomUUID();
        this.topicService.createTopic(id, topic.getUserId(), topic.getTitle(), topic.getContent());
    }
}
