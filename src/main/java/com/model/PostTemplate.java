package com.model;

public class PostTemplate {

    private int postId;
    private String userName;
    private String postTitle;
    private String postContent;

    public PostTemplate() {
    }

    public PostTemplate(int postId ,String userName , String postTitle , String postContent)
    {
        this.postId = postId;
        this.userName = userName;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "PostTemplate{" +
                "userName='" + userName + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postTitle='" + postTitle + '\'' +
                '}';
    }
}
