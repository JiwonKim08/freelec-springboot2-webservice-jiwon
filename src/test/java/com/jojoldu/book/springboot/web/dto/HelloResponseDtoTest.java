package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    //실제 값을 생성해서 내용이 맞는지 확인해본다.
    @Test
    public void 롬복_기능_테스트() {
        //given 준비
        String name = "test";
        int amount = 1000;

        //when 실행
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then 검증
        assertThat(dto.getName()).isEqualTo(name); //assertThat은 검증하고 싶은 대상을 메소드 인자로 받는다.
        assertThat(dto.getAmount()).isEqualTo(amount); //getName()과 getAmount에 값이 잘 들어가는지 확인한다.
    }
}
