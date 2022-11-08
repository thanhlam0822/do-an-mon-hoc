package com.example.comicweb.restcontroller;

import com.example.comicweb.model.Comic;
import com.example.comicweb.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ComicController {
    @Autowired
    ComicService comicService;
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
