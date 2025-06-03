package org.example.proxies.interfaces;

import org.example.model.Comment;

public interface INotificationProxy {
    public void sendCommentNotification(Comment comment);
}
