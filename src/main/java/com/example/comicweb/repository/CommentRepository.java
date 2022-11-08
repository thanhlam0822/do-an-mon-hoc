package com.example.comicweb.repository;

import com.example.comicweb.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query(value = " SELECT * from Comment c where c.user_id = ?1 and c.comic_id = ?2 ",nativeQuery = true)
    Comment findCommentByUserIdAndCommentId(long userId,long commentId);
    @Query(value = " SELECT * from Comment c where c.comic_id = ?1 ",nativeQuery = true)
    List<Comment> getAllByComicId(long comicId);
;}
