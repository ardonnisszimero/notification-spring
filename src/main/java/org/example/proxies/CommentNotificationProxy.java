package org.example.proxies;

import org.example.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentNotificationProxy implements ICommentNotificationProxy {

    @Override
    public void sendCommentNotification(Comment comment) {
        System.out.println("sending comment notification");
    }
}
