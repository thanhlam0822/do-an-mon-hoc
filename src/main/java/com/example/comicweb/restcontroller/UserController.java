package com.example.comicweb.restcontroller;

import com.example.comicweb.model.Comic;
import com.example.comicweb.model.Role;
import com.example.comicweb.model.User;
import com.example.comicweb.security.UserPrincipal;
import com.example.comicweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/user")//pre-path
public class UserController
{
    @Autowired
    private UserService userService;
    @GetMapping("favorite/{userId}")
    public List<Comic> getComicFavorite(@PathVariable("userId") long userId) {
         User user = userService.findById(userId);
         return user.getComics();
    }
    @GetMapping("follow/{userId}")
    public List<Comic> getComicFollow(@PathVariable("userId") long userId) {
        User user = userService.findById(userId);
        return user.getComicsFollowed();
    }
    @PutMapping("change/{role}")//api/user/change/{role}
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role)
    {
        userService.changeRole(role, userPrincipal.getUsername());

        return ResponseEntity.ok(true);
    }

}
