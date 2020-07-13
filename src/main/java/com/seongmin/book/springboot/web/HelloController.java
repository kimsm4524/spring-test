package com.seongmin.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//controller 를 json을 반환하는 컨트롤러로 변환한다.
public class HelloController {
    @GetMapping("/hello")
    //http get 요청을 받을수 있는 api를 만들수 있다.
    public String hello(){
        return "hello";
    }
}
