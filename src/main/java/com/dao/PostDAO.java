package com.dao;

import com.model.Post;
import com.model.PostTemplate;

import java.util.List;

public interface PostDAO {
    int createPost(Post post);
    List<PostTemplate> viewPosts();
}
