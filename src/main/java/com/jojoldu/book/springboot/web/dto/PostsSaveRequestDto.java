package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Entity 클래스와 거의 유사한 형태임에도 따로 생성했다. 그 이유는?
//Entity 클래스는 데베와 맞닿은 핵심 클래스이기에 자주 변경되어서는 안되기 때문이다.
//Entity 클래스는 서버를 위한 클래스이며, DTO는 view를 위한 클래스이다.
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
