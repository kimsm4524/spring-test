package com.seongmin.book.springboot.domain.posts;

import com.seongmin.book.springboot.domain.posts.Posts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuilderController {
    @GetMapping("/builder")
    public Posts buildertest(@RequestParam("author") String author, @RequestParam("content")String content, @RequestParam("title") String title){
        return new Posts(title, content,author);
    }
}
