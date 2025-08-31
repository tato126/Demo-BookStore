package org.example.demoBookStore.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 관리자(Admin) 컨트롤러에 대한 정보를 관리한다.
 * 현재는 조회의 기능만을 테스트 한다.
 * <p>
 * (!)는 우선적으로 개발해야함을 의미한다.
 * (~)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @GetMapping("/main")
    public String admin_mianPage() {

        System.out.println("== 관리자 메인 페이지 ==");

        return "admin-main";
    }

    // 주문한 상품 조회
    // Product product
    @GetMapping("/order")
    public String ordered_product() {

        // 조회할  상품 유효성 검사

        return "admin-orders";

    }

    // 주문한 상품 상세 조회
    // @PathVariable("id"), Product product
    @GetMapping("/order/detail")
    public String find_ordered_product() {

        // 상세 조회 화면 유효성 검사

        return "admin-order-detail";
    }

    // 재고 조회화면 이동
    public String 재고조회() {

        return "";
    }

    // 재고 조회 상세화면으로 이동
    public String 재고조회_상세화면() {

        return "";
    }

}
