package org.example;

import org.example.configuration.ProjectConfig;
import org.example.model.Cat;
import org.example.model.Comment;
import org.example.model.Dog;
import org.example.model.Person;
import org.example.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment("test", "test", "test");

        CommentService commentService = (CommentService) context.getBean("commentService");
        commentService.save(comment);
        commentService.sendNotification(comment);
    }
}