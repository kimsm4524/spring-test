package com.seongmin.book.springboot.web.posts;

import com.seongmin.book.springboot.domain.posts.Posts;
import com.seongmin.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
//스프링부트 테스트와 JUnit 사이에 연결자 역할
@SpringBootTest
//별다른 설정 없이 사용할 경우 H2 데이터베이스를 자동으로 실행해준다.
public class PostsRepositoryTest {
    @Autowired
    //스프링이 관리하는 빈을 주입받는다.
            PostsRepository postsRepository;

    @After
    //Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
    //테스트를 한번 실행할때마다 DB를 지워주는 느낌이다. 안지워질경우 오류가 생길수 있음
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() throws Exception {
        String title = "제목입니다.";
        String content = "내용입니다.";

        postsRepository.save(Posts.builder()
        .title(title)
        .content(content)
        .author("kimsm4524@gmail.com").build());

        List<Posts> postsList = postsRepository.findAll();
        //Repository를 모두 조회한다.

        Posts post = postsList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }
}
