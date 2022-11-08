package com.example.comicweb.service;

import com.example.comicweb.model.Comment;

import java.util.List;

public interface CommentService {
    Comment findCommentById(long commentId);
    List<Comment> getAllCommentInComic(long comicId);
    Comment findCommentByUserIdAndComicId(long userId,long comicId);
    void addComment(Comment comment);
    void deleteComment(long commentId);
}
