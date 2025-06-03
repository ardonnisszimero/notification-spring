package org.example.repository;

import org.example.model.Comment;
import org.example.repository.interfaces.ICommentRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class CommentRepository implements ICommentRepository {
    private static final Logger logger = Logger.getLogger(CommentRepository.class.getName());

    @Override
    public void save(Comment comment) {
        logger.info(comment.toString() + " saved\n" );
    }
}
