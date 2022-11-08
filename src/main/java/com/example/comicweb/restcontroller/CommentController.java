package com.example.comicweb.restcontroller;

import com.example.comicweb.model.Comic;
import com.example.comicweb.model.Comment;
import com.example.comicweb.model.User;
import com.example.comicweb.repository.UserRepository;
import com.example.comicweb.service.ComicService;
import com.example.comicweb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ComicService comicService;

    // Lấy comment theo tung id cua comic
    @GetMapping("comment/{comicId}")
    public List<Comment> getAllCommentInComic(@PathVariable("comicId") long comicId) {
        return commentService.getAllCommentInComic(comicId);
    }
    // lay comment theo tung id cua id va user
    @GetMapping("/{userId}/comment/{commicid}")
    public Comment findCommentInUser(@PathVariable("userId") long userId, @PathVariable("comicId") long comicId) {
        return commentService.findCommentByUserIdAndComicId(userId, comicId);
    }
    // Thêm mói một comment vào user và comic
    @PostMapping("/{userId}/comment/{commicid}")
    public Comment addComment(@PathVariable("userId") long userId, @PathVariable("comicId") long comicId,@RequestBody Comment comment) {
        Optional<User> list = userRepository.findById(userId);
        User tempUser = list.get();
        Comic tempComic = comicService.findComicById(comicId);
        comment.setUser(tempUser);
        comment.setComic(tempComic);
        commentService.addComment(comment);
        return comment;
    }
    // Chỉnh sửa comment từng Id
    @PutMapping("comment/{commentId}")
    public Comment updateComment(@PathVariable("commentId") long commentId, @RequestBody Comment comment) {
        comment.setId(commentId);
        commentService.addComment(comment);
        return comment;
    }
    // Xóa comment theo id
    @DeleteMapping("comment/{commentId}")
    public String deleteComment(@PathVariable("commentId") long commentId) {
        commentService.deleteComment(commentId);
        return "DELETE SUCCESSFUL";
    }

}
