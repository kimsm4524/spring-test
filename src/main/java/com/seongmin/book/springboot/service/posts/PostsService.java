package com.seongmin.book.springboot.service.posts;

import com.seongmin.book.springboot.domain.posts.PostsRepository;
import com.seongmin.book.springboot.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto)
    {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
