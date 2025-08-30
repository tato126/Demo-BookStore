package org.example.demoBookStore.admin.entity;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 관리자(Admin)에 대한 정보를 관리한다.
 * <p>
 * (!)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능인가를 의미한다.
 *
 * @author chan
 */
// 엔티티
public class Admin {

    // 관리자 식별번호 (PK)
    // (*) AdminId
//    private AdminId adminId;

    // 관리자 아이디
    private String adminName;

    // 관리자 비밀번호
    private String adminPassword;

    // 관리자 권한 (!)
    // (*) AdminRole
//    private AdminRole adminRole;

    // 관리자 생성일자
    public LocalDate createAdminDate;

    // 관리자 접속일자
    // (?) method_name
    public LocalTime admin_loginTime;

    // 관리자 작업 내용 (?)

    // 관리자는 관리자 관련 페이지를 이동할 수 있어야한다.

    // toString

    // Getter

    // toString

    // hashCode

    // equals


}
