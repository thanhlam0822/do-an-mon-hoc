package com.example.comicweb.restcontroller;

import com.example.comicweb.dto.UserDTO;
import com.example.comicweb.model.Comic;
import com.example.comicweb.model.Role;
import com.example.comicweb.model.User;
import com.example.comicweb.security.UserPrincipal;
import com.example.comicweb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/user")//pre-path
public class UserController
{
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/list")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
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
    @PutMapping("/edit/{userId}")
    public String editUser(@PathVariable("userId") long userId,  @RequestBody  String userName) {
        userService.updateTest(userName,userId);
        return "Success";
    }
    @PutMapping("/edit2/{userId}")
    @Transactional
    public User editUser2(@PathVariable("userId") long userId,  @RequestBody User user ) {
        User updatedUser = userService.findById(userId);
        updatedUser.setUsername(user.getUsername());

        user.setUsername(updatedUser.getUsername());
        user.setName(updatedUser.getName());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());
        user.setCreateTime(updatedUser.getCreateTime());

        return userService.update2(updatedUser);
    }


}
