package org.example.demoBookStore.product.entity;

import java.time.LocalDate;

/**
 * 책 상품(Book)에 대한 정보를 관리한다.
 *
 * (!)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 해당 코드의 발전 가능 기능을 의미한다.
 * @author chan
 */
public class Book {

    // 도서 식별 아이디
    // BookId
    private Long bookId;

    // 책 제목
    private String bookName;

    // 지은이
    private String author;

    // 출판사
    private String publisher;

    // ISBN
    private Long ISBN;

    // 책 이미지
//    private BookProfile bookProfile;

    // 판매 상태
//    private BookState bookState;

    // 책 소개
    private String bookContent;

    // 평점
    private String bookRating;

    // 상품 상태 (?)

    // 등록일
    private LocalDate create_Date;

    // 재고
//    private inventory book_inventory;

    // 권장 도서, 수상 이력

    // Getter

    // toString

    // hashCode

    // equals


}
