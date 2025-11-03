package com.model;

public class Comment {
    private int commentId;
    private String commentContent;
    private int postId;
    private int userId;

    public Comment() {
    }

    public Comment(int commentId , String commentContent , int postId , int userId)
    {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.postId = postId;
        this.userId = userId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentContent='" + commentContent + '\'' +
                ", commentId=" + commentId +
                ", postId=" + postId +
                ", userId=" + userId +
                '}';
    }
}
