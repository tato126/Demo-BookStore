package org.example.demoBookStore.user;

import java.time.LocalDate;

/**
 * 사용자(User) 컨트롤러에 대한 정보를 관리한다.
 *
 * (!)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
public class User {

    // 유저는 일단 간단하게 짜본다.

    // 유저 식별 번호
    // (*) UserId
    private Long userId;

    // 유저 아이디
    private String userName;

    // 유저 패스워드
    private String userPassword;

    // 유저 휴대전화번호
    private Long userPhone;

    // 유저 이메일
    private String userEmail;

    // 유저 상태
    private UserState userState;

    // 유저 등급 (!)
//    private UserLevel userLevel;

    // 구매한 상품 (*) 구매한 상품을 따로 묶을 수 있을까?
//    private Product 구매_상품;

    // 장바구니에 담은 상품 (*)
//    private Product 장바구니_상품;

    // 가입일
    private LocalDate createUserDate;

    // 탈퇴일
    private LocalDate secessionDate;

    // Getter

    // hashCode

    // equals

    // toString
}
