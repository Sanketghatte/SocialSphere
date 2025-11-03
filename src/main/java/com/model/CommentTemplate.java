package com.model;

public class CommentTemplate {

    private String userName;
    private String commentContent;

    public CommentTemplate() {
    }

    public CommentTemplate(String userName , String commentContent)
    {
        this.userName = userName;
        this.commentContent = commentContent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public String toString() {
        return "CommentTemplate{" +
                "userName='" + userName + '\'' +
                " ,commentContent='" + commentContent + '\'' +
                '}';
    }
}
