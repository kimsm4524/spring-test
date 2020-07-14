package com.seongmin.book.springboot.web.posts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
//스프링부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest
/*
Web(Spring MVC)에 집중할수 있는 어노테이션
선언할 경우
@Controller, @ControllerAdvice등을 사용할수 있음
@Service, @Component, @Repository 등은 사용할수 없음
*/
public class BuilderControllerTest {
    @Autowired
    //스프링이 관리하는 빈을 주입받는다.
    private MockMvc mvc;
    @Test
    public void builder가_리턴된다() throws Exception{
        String author = "abc";
        String title = "abdd";
        String content = "abddc";
        mvc.perform(
                get("/builder")
                        .param("author",author)//API테스트에서 요청 파라미터 설정, String만 가능
                        .param("title",title)
                        .param("content",content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author",is(author)))//json 응답값을 필드별로 검증, $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.title",is(title)))
                .andExpect(jsonPath("$.content",is(content)));
    }
}
