package org.example.repository;

import org.example.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository implements ICommentRepository {
    @Override
    public void save(Comment comment) {
        System.out.println("saved comment");
    }
}
