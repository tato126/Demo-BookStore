package org.example.demoBookStore.product.dto;

import lombok.*;

import java.time.LocalDate;

/**
 * 도서 상품(Book)에 대한 정보를 관리한다.
 * <p>
 * (!)는 우선적으로 개발해야함을 의미한다.
 * (~)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 해당 코드의 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book {

    //     1. 기본 정보

    // (*) Long -> BookId
    private Long bookId; // 도서 아이디
    
    private String bookName; // 상품명

    // (?) String -> author
    private String author; // 저자
    private String publisher; // 출판사

    // (*) Long -> ISBN
    private Long isbn; // 국제표준도서번호 (10~13자리) 도서의 고유한 값이다.

    // (*) String -> BookCategory(Enum)
    private String bookCategory; // 도서 카테고리
    private LocalDate publishDate; // 출간일

    //     2. 가격 정보
    // (?) int -> BigInt
    private int regularPrice; // 정가
    private int salePrice; // 판매가
    private int discountRate; // 할인율

    //     3. 재고 정보
    // (*) Long -> Inventory -> BookInventory
    private Long product; // 기본 재고
    private Long minProduct; // 최소 재고
    private Long maxProduct; // 최대 재고

    //     4. 상품 설명
    private String explanation; // 도서 설명

    // 재고
    // private inventory book_inventory;

    // 권장 도서, 수상 이력

}
