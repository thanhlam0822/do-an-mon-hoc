package com.example.comicweb.restcontroller;


import com.example.comicweb.dto.CategoryListDTO;
import com.example.comicweb.dto.ComicDTO;
import com.example.comicweb.dto.ComicRankingDTO;
import com.example.comicweb.model.Category;
import com.example.comicweb.model.Comic;
import com.example.comicweb.model.ComicChapters;
import com.example.comicweb.model.User;
import com.example.comicweb.service.CategoryService;
import com.example.comicweb.service.ComicService;
import com.example.comicweb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<ComicDTO> searchComics(@RequestParam String query,@RequestParam(defaultValue = "0",required = false) Integer pageNumber,
                                       @RequestParam(defaultValue = "10",required = false) Integer pageSize) {
//        return  comicService.findComicByName(name);
        List<ComicDTO> comicDTOS = comicService.findComicByName(query,pageNumber,pageSize);
        return comicDTOS;
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
    @PostMapping("comic/{categoryId}")
    public Comic addComic(@RequestBody Comic comic,@PathVariable("categoryId") Long categoryId ) {
        Category category = categoryService.findCategoryById(categoryId);
        List<Category> comicCategory = comic.getCategories();
        comicCategory.add(category);
        comic.setCategories(comicCategory);
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
    @GetMapping("search2")
    public List<ComicDTO> filterComic(@RequestParam String query1,
                                      @RequestParam(required = false) String query2,
                                      @RequestParam(defaultValue = "0",required = false) Integer pageNumber,
                                      @RequestParam(defaultValue = "10",required = false) Integer pageSize) {
        List<ComicDTO> comicDTOS = comicService.filterComic(query1,query2,pageNumber,pageSize);
        return comicDTOS;
    }

    @GetMapping("comicdto/{comicId}")
    public ComicDTO getComicDtoById(@PathVariable("comicId") long comicId) {
        return comicService.findComicDtoById(comicId);
    }

}
