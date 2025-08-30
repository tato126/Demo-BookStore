package org.example.demoBookStore.product.service;

/**
 * 도서(Book) 대한 서비스 클래스이다.
 *
 * (!)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
public class BookService {

    // 상품 등록
    public void add_product() {}

    // 상품 수정
    public void update_product() {}

    // 상품 조회
    public void find_product() {}

    // 상품 전체 조회
    public void findAll_product() {}

    // 상품 삭제
    public void delete_product() {}

    // 판매 상태 체크 (?)
    public void check_product_State() {

        // 현재 상태가 판매, 품절 , 판매 대기인지 확인한다.
    }

    // 재고 상태 체크
    public void check_inventory() {

        // 재고는 0보다 작을 수 없다.
    }
}
