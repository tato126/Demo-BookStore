package org.example.demoBookStore.admin.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 관리자(Admin) 로그인 컨트롤러에 대한 정보를 관리한다.
 * 현재는 컨트롤러에서의 하드 코딩을 통해 테스트한다.
 * <p>
 * (!)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
@RequestMapping("/admin/login")
@Controller
public class LoginController {

    // 로그인 페이지로 이동한다.
    @GetMapping
    public String login_page() {

        System.out.println("== 로그인 화면호출 ==");

        return "admin-login";
    }

    // 로그인 정보를 입력한다.
    // (*) 로그인 성공, 실패 로직을 따로 분리할 수 있다.
    @PostMapping
    public String login_process(String adminId, String adminPwd, Model model) {

        System.out.println("== 사용자가 정보를 입력한다. ==");

        System.out.println("입력한 어드민 아이디" + adminId);
        System.out.println("입력한 어드민 pwd" + adminPwd);

        model.addAttribute("adminId", adminId);
        model.addAttribute("adminPwd", adminPwd);

        // 아이디가 일치하는지 확인한다.
        if (!(adminId.equals("admin") && adminPwd.equals("admin123"))) {

            System.out.println("아이디가 일치합니다.");

            return "redirect:/admin/login";
        }

        return "admin-main";
    }
}
