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

    @GetMapping("/comic")
    public List<Comic> GetAllComic() {
        return comicService.getAllComic();
    }
    @GetMapping("comic/{comicId}")
    public Comic getComicById(@PathVariable("comicId") long comicId) {
        return comicService.findComicById(comicId);
    }
    @PostMapping("/comic")
    public Comic addComic(@RequestBody Comic comic) {
         comicService.addComic(comic);
         return comic;
    }
    @PutMapping("comic/{comicId}")
    public Comic updateComic(@PathVariable("comicId") long comicId,@RequestBody Comic comic) {
        comic.setId(comicId);
        comicService.addComic(comic);
        return comic;
    }
    @DeleteMapping("comic/{comicId}")
    public String deleteComic(@PathVariable("comicId") long comicId) {
        comicService.deleteComic(comicId);
        return "DELETE SUCCESSFULL!!!!";
    }

}
