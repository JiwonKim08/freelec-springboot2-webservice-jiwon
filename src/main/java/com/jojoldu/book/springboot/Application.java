package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링부트의 자동 설정, 스프링 bean 읽기와 생성 자동 설정 => 프로젝트 최상단에 위치
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    } //내부 WAS로 인해 톰캣을 설치할 필요가 없다.
}
