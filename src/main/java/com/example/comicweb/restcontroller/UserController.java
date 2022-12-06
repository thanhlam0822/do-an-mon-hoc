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
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
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
    @PutMapping ("edit/{userId}")
    public String editUser(@PathVariable("userId") long userId ,  @RequestBody User user ) {
        User tempUser = userService.findById(userId);

//        if( user.getUsername() == null) {
//            user.setUsername(tempUser.getUsername());
//        }
        tempUser.setUsername(user.getUsername() == null ? tempUser.getUsername() : user.getUsername());
        tempUser.setGmail(user.getGmail() == null ? tempUser.getGmail() : user.getGmail());
        tempUser.setJob(user.getJob() == null ? tempUser.getJob() : user.getJob());
        tempUser.setPosition(user.getPosition() == null ? tempUser.getPosition() : user.getPosition());
        tempUser.setCreateTime(user.getCreateTime() == null ? tempUser.getCreateTime() : user.getCreateTime());
        tempUser.setName(user.getName() == null ? tempUser.getName() : user.getName());
        tempUser.setPassword(user.getPassword() == null ? tempUser.getPassword() : user.getPassword());
        tempUser.setRole(user.getRole() == null ? tempUser.getRole() : user.getRole());







//         if (user.getGmail() == null) {
//            user.setGmail(tempUser.getGmail());
//        }

//         if (user.getJob() == null) {
//            user.setJob(tempUser.getJob());
//        }
//         if (user.getPosition() == null) {
//            user.setPosition(tempUser.getPosition());
//        }
//         if (user.getCreateTime() == null) {
//            user.setCreateTime(tempUser.getCreateTime());
//        }
//        if (user.getName() == null) {
//            user.setName(tempUser.getName());
//        }
//         if (user.getPassword() == null) {
//            user.setPassword(tempUser.getPassword());
//        }
//         if (user.getRole() == null) {
//            user.setRole(tempUser.getRole());
//        }
        userService.updateUser(tempUser);
        return "Success";
    }
    @PutMapping("{id}")
    public List<User> removeUser(@PathVariable("id") Long id) {
        userService.deleteUSer(id);
        return userService.getAllUser();

    }




}
