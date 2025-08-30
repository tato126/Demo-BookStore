package org.example.demoBookStore.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 관리자(Admin) 컨트롤러에 대한 정보를 관리한다.
 * 현재는 조회의 기능만을 테스트 한다.
 *
 * (!)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    // 관리자가 로그인을 한다.
    @GetMapping("/login")
    public String admin_login() {

        // 실패시 로그인 화면으로 이동한다.
        // 로그인 성공시 관리자 메인 페이지로 이동한다.

//        if (!isLogin) {
//            return "redirect:/";
//        }

        System.out.println("관리자 로그인 페이지");

        return "admin-login";
    }

    @GetMapping("/main")
    public String admin_mianPage() {

        System.out.println("관리자 메인 페이지");

        return "admin-main";
    }

    // 관리자가 상품 목록으로 이동한다.
    @GetMapping("/product")
    public String admin_productPage() {

        // 상점에 등록된 상품을 조회한다.
//        productService.findAll();

        System.out.println("관리자 상품 목록 페이지");

        return "admin-products";
    }

    // 상품 상세 페이지로 이동한다.
    // GetMapping("/product/{id}")
    // PathVariable
    @GetMapping("/product/detail")
    public String detail_상품리스트() {

        // 상품 상세 정보를 가져온다.
        System.out.println("관리자 상품 상세 페이지");

        return "admin-product-detail";
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
