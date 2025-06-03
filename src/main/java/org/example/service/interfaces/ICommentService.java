package org.example.service.interfaces;

import org.example.model.Comment;

public interface ICommentService {

    public void save(Comment comment);
    public void sendNotification(Comment comment);
}
