package org.example.service;

import org.example.model.Comment;
import org.example.proxies.interfaces.INotificationProxy;
import org.example.repository.interfaces.ICommentRepository;
import org.example.service.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {
    private final ICommentRepository commentRepository;

    private final INotificationProxy commentNotificationProxy;

    public CommentService(@Qualifier("emailNotificationProxy") INotificationProxy notificationProxy, ICommentRepository commentRepository ) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = notificationProxy;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void sendNotification(Comment comment) {
        commentNotificationProxy.sendCommentNotification(comment);
    }
}
