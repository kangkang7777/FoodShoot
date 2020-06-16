package com.project.foodshoot.service.impl;

import com.project.foodshoot.entity.Comment;
import com.project.foodshoot.mapper.CommentMapper;
import com.project.foodshoot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public void addComment(int userId, int recipeId, String content){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String publishTime = simpleDateFormat.format(new Date());
        commentMapper.addComment(userId, recipeId, content, publishTime);
    }

    public List<Comment> getCommentsByRecipeId(int recipeId){
        return commentMapper.getCommentsByRecipeId(recipeId);
    }

    public List<Comment> getCommentsByUserId(int userId){
        return commentMapper.getCommentsByUserId(userId);
    }

    public void deleteCommentByCommentId(int commentId){
        commentMapper.deleteCommentByCommentId(commentId);
    }

    public void deleteCommentsByRecipeId(int recipeId){
        commentMapper.deleteCommentsByRecipeId(recipeId);
    }
}
