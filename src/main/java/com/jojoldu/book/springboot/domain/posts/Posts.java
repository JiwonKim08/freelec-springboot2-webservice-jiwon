package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//실제 DB의 테이블과 매칭될 클래스(Entity class)
//JPA 사용시 DB 데이터에 작업할 경우 실제 쿼리를 날리기 보다, 이 클래스로 작업가능
@Getter //Getter 메소드를 자동 생성
//Entity 클래스에서는 Setter 메소드를 만들지 않음
//Setter가 없는데 어떻게 값을 채워 DB에 삽입?
//생성자를 통해 최종값을 채운 후 DB에 삽입 => @Builder로 대체 가능

@NoArgsConstructor //기본 생성자 자동 추가
@Entity //테이블과 링크될 클래스임을 명시
public class Posts extends BaseTimeEntity {

    @Id //해당 테이블의 PK 필드를 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙을 명시
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 열을 나타내며, 굳이 선언하지 않아도 해당 클래스의 필드는 모두 열이 된다. 기본 속성을 바꾸고 싶을 때 명시
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
