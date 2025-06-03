package org.example.proxies;

import org.example.model.Comment;

public interface ICommentNotificationProxy {
    public void sendCommentNotification(Comment comment);
}
