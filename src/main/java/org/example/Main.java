package org.example;

import org.example.configuration.ProjectConfig;
import org.example.model.Comment;
import org.example.service.interfaces.ICommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment("test", "test", "test");

        var commentService = context.getBean(ICommentService.class);  //Because by default spring using JDK dynamic proxies
        //that means that the bean that has the target method that will get intercepted will need to be injected/implemented via its
        //interface.

        //However if we use CGLIB proxies instead (by adding proxyTargetClass = true when we enable AOP for spring). Then
        //spring can create proxies by subclassing meaning no need for interfaces. :).

        commentService.save(comment);
        commentService.sendNotification(comment);
    }
}