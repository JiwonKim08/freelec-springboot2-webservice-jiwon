package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //테스트 실행자 설정
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)
public class HelloControllerTest {

    @Autowired //스프링이 관리하는 Bean을 주입 받는다.
    private MockMvc mvc; //웹 API를 테스트할 때 사용한다.

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //mvc를 통해 /hello 주소로 GET요청을 합니다. 체이닝이 지원됩니다.
                .andExpect(status().isOk()) //response가 200인지 아닌지를 검증합니다.
                .andExpect(content().string(hello)); // /hello 주소의 내용이 맞는지 검증합니다.
    }

    //롬북은 프로젝트마다 설치해야하며, plugin은 한 번만 설치하면 된다.
    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                    get("/hello/dto")
                            .param("name", name) //API 테스트시 사용될 요청 파라미터를 설정한다. 단 String만 허용된다.
                            .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //jsonPath는 json 응답값을 필드별로 검증할 수 있는 메소드이다.
                .andExpect(jsonPath("$.amount", is(amount))); //$를 기준으로 필드명을 명시한 후 넘어온 값과 일치하는지 검증한다.
    }
}

//이로써 API가 정상적으로 돌아가는지 확인할 수 있다.