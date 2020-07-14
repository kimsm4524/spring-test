package com.seongmin.book.springboot.web.dto;

import com.seongmin.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/*
Entity 클래스와 유사한 형태이지만 Entity 클래스는 Request/Response 클래스로 사용하면 안된다.
Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스로, 최대한 변경을 피하고 따로 Dto를 분리해서 사용해야한다.
 */
@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostSaveRequestDto(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}

