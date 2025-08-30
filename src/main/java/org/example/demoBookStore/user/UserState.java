package org.example.demoBookStore.user;

/**
 * 사용자(User) 계정 상태를 관리하는 열거형(Enum) 클래스.
 *
 * (!)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
public enum UserState {

    ACTIVE,
    INACTIVE

    // 탈퇴한 유저
}
