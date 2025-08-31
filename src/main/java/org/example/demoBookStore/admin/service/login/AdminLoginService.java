package org.example.demoBookStore.admin.service.login;

import org.springframework.stereotype.Service;

/**
 * 관리자(Admin)의 로그인 서비스 로직 관리한다.
 * <p>
 * (!)는 우선적으로 개발해야함을 의미한다.
 * (~)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
@Service
public class AdminLoginService {

    // 로그인 로직
    // (*) 로그인 실패 , 로그인 성공 등의 메서드를 따로 분리할 수 있을 것 같다.
    // (?) 객체(Admin)을 리턴한다.
    // (?) Boolean을 리턴한다.
    public boolean check_login(String adminId, String adminPwd) {

        System.out.println("[Service] 로그인 유효성 검사");

        // 저장된 로그인 정보가 null 인지 확인한다.
        if ((adminId.equals("admin") && adminPwd.equals("admin123"))) {

            System.out.println("로그인 성공!");
            System.out.println("입력받은 아이디가 admin 입니다.");
            System.out.println("입력받은 비밀번호가 admin123이 입니다.");

            return true;
        }

        // TODO: 만약 저장된 로그인 정보가 없으면 예외처리한다.

        return false;
    }

    // 로그아웃 로직
    public boolean check_Logout(String adminId, String adminPwd) {

        // 차후 세션에서 로그인한 정보가 사라져야한다.

        return false;
    }
}
