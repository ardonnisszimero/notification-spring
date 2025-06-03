package org.example.service;

import org.example.aspects.LoggingAspect;
import org.example.configuration.ProjectConfig;
import org.example.model.Comment;
import org.example.proxies.interfaces.INotificationProxy;
import org.example.repository.interfaces.ICommentRepository;
import org.example.service.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.configuration.ProjectConfig.checkAccess;

@Service
public class CommentService implements ICommentService {
    private final ICommentRepository commentRepository;

    private final INotificationProxy commentNotificationProxy;

    private static final Logger logger =  Logger.getLogger(CommentService.class.getName());

    public CommentService(@Qualifier("emailNotificationProxy") INotificationProxy notificationProxy, ICommentRepository commentRepository ) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = notificationProxy;
    }


    @Override
    public void save(Comment comment) {
        logger.log(Level.INFO, "Saving comment {0} \n", comment);
        commentRepository.save(comment);
    }

    @Override
    @checkAccess
    public void sendNotification(Comment comment) {
        commentNotificationProxy.sendCommentNotification(comment);
    }
}
