package com.dao;

import com.model.Comment;
import com.model.CommentTemplate;

import java.util.List;

public interface CommentDAO {
    int createComment(Comment comment);
    List<CommentTemplate> viewComments(int postId);
}
