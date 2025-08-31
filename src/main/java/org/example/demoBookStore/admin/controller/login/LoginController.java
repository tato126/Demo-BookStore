package org.example.demoBookStore.admin.controller.login;

import org.example.demoBookStore.admin.service.login.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 관리자(Admin) 로그인 컨트롤러에 대한 정보를 관리한다.
 *
 * (!)는 우선적으로 개발해야함을 의미한다.
 * (~)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
@RequestMapping("/admin/login")
@Controller
public class LoginController {

    @Autowired
    AdminLoginService adminLoginService;

    // 로그인 페이지로 이동한다.
    @GetMapping
    public String login_page() {

        System.out.println("== 어드민 로그인 화면호출 ==");

        return "admin-login";
    }

    // 로그인 정보를 입력한다.
    // (*) 로그인 성공, 실패 로직을 따로 분리할 수 있다.
    @PostMapping
    public String login_process(String adminId, String adminPwd) {

        System.out.println("== 어드민이 로그인을 입력한다. ==");

        var checkLogin = adminLoginService.check_login(adminId, adminPwd);

        System.out.println("로그인 가능 상태: " + checkLogin);

        // 아이디가 일치하는지 확인한다.
        if (!checkLogin) {

            System.out.println("아이디가 일치하지 않습니다.");

            return "redirect:/admin/login";
        }

        return "admin-main";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout_process() {

        System.out.println("== 어드민이 로그아웃 한다.");

        // 어떤 유효성 검사가 있어야 할까?
        // 차후 세션에서 로그인한 값이 사라져야 한다.

        return "redirect:/admin/login";
    }
}
