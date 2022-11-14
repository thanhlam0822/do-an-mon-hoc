package com.example.comicweb.restcontroller;

import com.example.comicweb.model.Comic;
import com.example.comicweb.model.User;
import com.example.comicweb.service.ComicService;
import com.example.comicweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ComicController {
    @Autowired
    ComicService comicService;
    @Autowired
    UserService userService;
    // Lấy mọi comic đã sẵn có trên database
    @GetMapping("/comic")
    public List<Comic> GetAllComic() {
        return comicService.getAllComic();
    }
    // Lấy comic theo Id
    @GetMapping("comic/{comicId}")
    public Comic getComicById(@PathVariable("comicId") long comicId) {
        return comicService.findComicById(comicId);
    }
    @GetMapping("category/{categoryId}/comic")
    public List<Comic> getAllComicByCategory(@PathVariable("categoryId") long categoryId) {
        return comicService.getAllComicByCategory(categoryId);
    }
    // Thêm mới một comic
    @PostMapping("/comic")
    public Comic addComic(@RequestBody Comic comic) {
         comicService.addComic(comic);
         return comic;
    }
    /* Them truyen vao danh sach yeu thich */
    @PostMapping("/comic/favorite/{userId}/{comicId}")
    public Comic addFavorite(@PathVariable("userId") long userId,@PathVariable("comicId") long comicId) {
        User user = userService.findById(userId);
        Comic comic = comicService.findComicById(comicId);
        List<Comic> favorites = user.getComics();
        favorites.add(comic);
        user.setComics(favorites);
        userService.saveUser(user);
        return comic;
    }
    // Them truyen vao danh sach dang theo doi
    @PostMapping("/comic/following/{userId}/{comicId}")
    public Comic addFollowing(@PathVariable("userId") long userId,@PathVariable("comicId") long comicId) {
        User user = userService.findById(userId);
        Comic comic = comicService.findComicById(comicId);
        List<Comic> follows = user.getComicsFollowed();
        follows.add(comic);
        user.setComicsFollowed(follows);
        userService.saveUser(user);
//        List<User> userList = comic.getUserFollow();
//        userList.add(user);
//        comic.setUsers(userList);
//        comicService.addComic(comic);
        return comic;
    }
    // Chinh sua mot comic
    @PutMapping("comic/{comicId}")
    public Comic updateComic(@PathVariable("comicId") long comicId,@RequestBody Comic comic) {
        comic.setId(comicId);
        comicService.addComic(comic);
        return comic;
    }
    // Xoa comic bang id
    @DeleteMapping("comic/{comicId}")
    public String deleteComic(@PathVariable("comicId") long comicId) {
        comicService.deleteComic(comicId);
        return "DELETE SUCCESSFULL!!!!";
    }

}
