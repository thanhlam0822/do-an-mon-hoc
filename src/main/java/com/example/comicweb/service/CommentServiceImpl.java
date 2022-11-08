package com.example.comicweb.service;

import com.example.comicweb.model.Comment;
import com.example.comicweb.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment findCommentById(long commentId) {
        Optional<Comment> list =  commentRepository.findById(commentId);
        Comment theComment = list.get();
        return theComment;
    }

    @Override
    public List<Comment> getAllCommentInComic(long comicId) {
        return commentRepository.getAllByComicId(comicId);
    }

    @Override
    public Comment findCommentByUserIdAndComicId(long userId, long comicId) {
        return findCommentByUserIdAndComicId(userId,comicId);
    }

    @Override
    public void addComment(Comment comment) {
       commentRepository.save(comment);
    }

    @Override
    public void deleteComment(long commentId) {
       commentRepository.deleteById(commentId);
    }
}
