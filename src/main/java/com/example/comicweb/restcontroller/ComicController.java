package com.example.comicweb.restcontroller;


import com.example.comicweb.dto.CategoryDTO;
import com.example.comicweb.dto.ComicDTO;
import com.example.comicweb.dto.ComicRankingDTO;
import com.example.comicweb.model.Category;
import com.example.comicweb.model.Comic;
import com.example.comicweb.model.User;
import com.example.comicweb.service.CategoryService;
import com.example.comicweb.service.ComicService;
import com.example.comicweb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ComicController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ComicService comicService;
    @Autowired
    UserService userService;
    // Lấy mọi comic đã sẵn có trên database
    @GetMapping("/comic")
    public List<ComicDTO> GetAllComic(@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
                                      @RequestParam(value = "pageSize",defaultValue = "8",required = false) Integer pageSize) {
//        return comicService.getAllComic().stream().map(comic -> modelMapper.map(comic, ComicDTO.class))
//                .collect(Collectors.toList());
        List<ComicDTO> comicDTOS = comicService.getAllComic(pageNumber,pageSize);
        return comicDTOS;
    }
    // Lấy comic theo Id
    @GetMapping("comic/{comicId}")
    public Comic getComicById(@PathVariable("comicId") long comicId) {
        return comicService.findComicById(comicId);
    }
    @GetMapping("category/{categoryId}/comic")
    public List<Comic> getAllComicByCategory(@PathVariable("categoryId") long categoryId) {
        Category category =categoryService.findCategoryById(categoryId);
        List<Comic> comics = category.getComics();

        return comics;
    }
    @GetMapping("/search")
    public List<ComicDTO> searchComics(@RequestParam("name") String name) {
        return  comicService.findComicByName(name);
    }
    @GetMapping("/ranking/day")
    public List<ComicRankingDTO> rankingDay() {
        return comicService.rankingDay();

    }
    @GetMapping("/ranking/week")
    public List<ComicRankingDTO> rankingWeek() {
        return comicService.rankingWeek();

    }
    @GetMapping("/ranking/month")
    public List<ComicRankingDTO> rankingMonth() {
        return comicService.rankingMonth();

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
