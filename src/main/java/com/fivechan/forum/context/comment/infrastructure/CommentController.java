package com.fivechan.forum.context.comment.infrastructure;

import com.fivechan.forum.context.comment.application.CreateComment;
import com.fivechan.forum.context.comment.domain.Comment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CreateComment createComment;

    @PostMapping
    public void createComment(@RequestBody Comment comment) {
        createComment.run(comment.getId(), comment.gettopicId(), comment.getUserAuthId(), comment.getContent());
    }
}
