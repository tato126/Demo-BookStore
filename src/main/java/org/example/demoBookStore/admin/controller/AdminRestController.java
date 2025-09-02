package org.example.demoBookStore.admin.controller;

import org.example.demoBookStore.dto.TestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 관리자(Admin) 로그인 api 컨트롤러에 대한 정보를 관리한다.
 * 현재는 컨트롤러에서의 하드 코딩을 통해 테스트한다.
 * <p>
 *
 * (!)는 우선적으로 개발해야함을 의미한다.
 * (~)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
@RequestMapping("/api/admin")
@RestController
public class AdminRestController {

    // 간단한 api 테스트 코드
    public String getTest() {

        return "GET 성공";
    }

    // 200 응답을 반환한다.
    @GetMapping("/{id}")
    public ResponseEntity<String> test(@PathVariable("id") String id) {

        System.out.println("TestMethod : id:" + id);

        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

    @GetMapping("/testDto")
    public ResponseEntity<TestDto> dtoTest() {

        TestDto testDto = new TestDto("거니 형", "멋진 거니형");

        System.out.println("Dto 테스트 메서드");

//        testDto.setName("거니 형");
//        testDto.setPassword("멋진 거니형");

        testDto.toString();

        return ResponseEntity.status(HttpStatus.OK).body(testDto);
    }

    // 400 응답을 반환
    @GetMapping("/badRequest/{id}")
    public ResponseEntity<TestDto> test2(@PathVariable("id") String id) {

        TestDto testDto = new TestDto("chan", "password");

        System.out.println("BadMethod : id:" + id);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(testDto);
    }


}