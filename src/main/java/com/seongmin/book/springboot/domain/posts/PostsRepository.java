package com.seongmin.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*
Entity class와 Repository는 함께 위치 해야한다.
 둘은 밀접한 관계이고, Entity클래스는 Repository 없이는 제대ㅗㄹ 역할을 할 수가 없기 때문이다.

 */

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
