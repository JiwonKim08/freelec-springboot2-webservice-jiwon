package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Post 클래스로 Database를 접근하게 해줄 DAO = Repository를(DB 접근자) 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {
    //상속하면 기본적인 CRUD 메소드 자동 생성
    //Entity클래스와 Repository는 함께 위치해야 한다.

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();


}
