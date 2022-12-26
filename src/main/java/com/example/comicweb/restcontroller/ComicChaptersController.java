package com.example.comicweb.restcontroller;

import com.example.comicweb.dto.ComicChaptersDTO;
import com.example.comicweb.service.ComicChaptersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ComicChaptersController {
    @Autowired
    ComicChaptersService comicChaptersService;
    @GetMapping("comic/{comicId}/chapter")
    public List<ComicChaptersDTO> getAllChapter(@PathVariable Long comicId,
                                                @RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
                                                @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize)
    {
        List<ComicChaptersDTO> comicChaptersDTOList = comicChaptersService.getAllChapter(comicId,pageNumber,pageSize);
        return  comicChaptersDTOList;
    }
    @GetMapping("chapter/{id}")
    public ComicChaptersDTO getById(@PathVariable Long id) {
        return comicChaptersService.getChapterById(id);
    }
}
