package com.seongmin.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
//스프링부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest
/*
Web(Spring MVC)에 집중할수 있는 어노테이션
선언할 경우
@Controller, @ControllerAdvice등을 사용할수 있음
@Service, @Component, @Repository 등은 사용할수 없음
*/
public class HelloControllerTest {
    @Autowired
    //스프링이 관리하는 빈을 주입받는다.
    private MockMvc mvc;
    //web API 를 테스트 할때 사용한다. get,post 등에 대한 테스트를 할수 있다.
    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello"))//MockMvc를 통해 /hello주소로 http get 요청을 한다.
                .andExpect(status().isOk())//mvc.perform 결과를 검증하고, header의 status(200,404,500등)을 검증한다. 200 = isok
                .andExpect(content().string(hello));//mvc.perform의 결과를 검증, hello를 리턴하는지 검증
    }
    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;
        mvc.perform(
                get("/hello/dto")
                .param("name",name)//API테스트에서 요청 파라미터 설정, String만 가능
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))//json 응답값을 필드별로 검증, $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount",is(amount)));

    }

}
