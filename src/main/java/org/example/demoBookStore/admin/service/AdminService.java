package org.example.demoBookStore.admin.service;

/**
 * 관리자(Admin) 서비스에 대한 정보를 관리한다.
 *
 * (!)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
public class AdminService {

    // 로그인 검사
    public void check_login() {

        // 저장된 로그인 정보가 있는지 확인한다.
        // 만약 저장된 로그인 정보가 없으면 예외처리한다.

    }

    // 상품 조회
    public void find_product() {

        // 상품 조회 리스트가 있는지 확인한다.
        // 만약 저장된 상품이 하나도 없다면 예외처리 (?)
    }

    // 회원 조회
    public void find_user() {

        // 회원 저장소에 저장된 회원이 있는지 확인한다.
        // 만약 저장된 상품이 하나도 없다면 예외처리 (?)
    }

    // 회원 수정 (?)
    public void update_user() {

        // 저장된 회원 정보를 불러온다.
        // 현재 회원 정보를 확인한다.
        // 변경된 회원 정보가 유효한 정보 변경인지 검사한다.
        // 만약 유효하지 않으면 예외처리

    }

    // 회원 삭제
    public void delete_user() {

    }

    // 주문된 상품 조회
    public void find_ordered_product() {

    }

    // 주문된 상품 수정
    public void add_ordered_product() {

    }

    // 주문된 상품 삭제
    public void delete_ordered_product() {

    }

    // (?)
    // 상품 재고 조회 (?) 상품 재고까지 가야할까?
    public void find_상품재고_조회() {

    }

    // 상품 재고 수정 (?)

    // 상품 재고 삭제 (?)

}
