package com.model;

public class Post {
    private int postId;
    private String postTitle;
    private String postContent;
    private int userId;

    public Post() {
    }

    public Post(int postId, String postTitle, String postContent, int userId) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postContent='" + postContent + '\'' +
                ", postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", userId=" + userId +
                '}';
    }
}
