package org.example.service;

import org.example.model.Comment;
import org.example.proxies.ICommentNotificationProxy;
import org.example.repository.ICommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {
    private final ICommentRepository commentRepository;

    private final ICommentNotificationProxy commentNotificationProxy;

    public CommentService(ICommentNotificationProxy notificationProxy, ICommentRepository commentRepository ) {
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
