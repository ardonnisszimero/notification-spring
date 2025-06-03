package org.example.proxies;

import org.example.model.Comment;
import org.example.proxies.interfaces.INotificationProxy;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationProxy implements INotificationProxy {
    @Override
    public void sendCommentNotification(Comment comment) {
        System.out.println("Sending email comment notification. ");
    }
}
