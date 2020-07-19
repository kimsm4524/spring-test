package com.seongmin.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
//JPA Auditing 활성화
//JPA Auditing : 생성 수정에 대한 정보를 자동으로 가져올수 있다.
@SpringBootApplication
public class Application {
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class,args);
        //내장 was 실행
    }
}
