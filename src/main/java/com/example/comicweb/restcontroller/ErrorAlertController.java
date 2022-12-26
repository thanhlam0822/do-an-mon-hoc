package com.example.comicweb.restcontroller;

import com.example.comicweb.model.ComicChapters;
import com.example.comicweb.model.ErrorAlert;
import com.example.comicweb.model.User;
import com.example.comicweb.service.ComicChaptersService;
import com.example.comicweb.service.ErrorAlertService;
import com.example.comicweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ErrorAlertController {
    @Autowired
    ErrorAlertService errorAlertService;
    @Autowired
    UserService userService;
    @Autowired
    ComicChaptersService comicChaptersService;
    @PostMapping("error-alert/{userId}/{chapterId}")
    public ErrorAlert addErrorAlert(
            @PathVariable Long userId,
            @PathVariable Long chapterId,
            @RequestBody ErrorAlert errorAlert)
    {
        User user =  userService.findById(userId);
        ComicChapters comicChapters = comicChaptersService.findById(chapterId);
        errorAlert.setUser(user);
        errorAlert.setComicChapters(comicChapters);
        errorAlertService.addErrorAlert(errorAlert);
       return errorAlert;
    }
}
