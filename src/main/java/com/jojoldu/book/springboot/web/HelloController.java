package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 json을 반환하도록 만든다.
public class HelloController {

    @GetMapping("/hello") //HTTP method 중 GET의 요청을 받을 수 있도록 api를 만든다.
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
    //@RequestParam는 외부에서 API로 넘긴 파라미터를 가져온다. 여기서는 가져와서 @RequestParam("name")라는 이름으로 넘긴 파라미터를
    //String name에 저장한다. 그후 리턴값으로 HelloResponseDto에 값을 전달한다.
}
