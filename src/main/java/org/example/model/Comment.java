package org.example.model;

public class Comment {
    private String comment;
    private String author;
    private String date;

    public Comment(String date, String comment, String author) {
        this.date = date;
        this.comment = comment;
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
