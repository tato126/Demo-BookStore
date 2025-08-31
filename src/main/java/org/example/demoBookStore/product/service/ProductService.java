package org.example.demoBookStore.product.service;

import org.example.demoBookStore.product.dto.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 도서(Book) 비즈니스 로직 클래스이다.
 * <p>
 * (!)는 우선적으로 개발해야함을 의미한다.
 * (~)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
@Service
public class ProductService {

    List<Book> bookList = new ArrayList<>(); // 등록한 상품 관리 리스트 배열

    // 상품(Book)을 등록한다.
    public Book registry_product(Book book) {

        System.out.println("== [Service] 상품 등록 ==");

        // 유효성 검사
        // (*) 도서(Book) 생성자에서 필드를 Object.requiredNotNull로 검사할 수 있다.
        if (book == null) {
            System.out.println("도서(Book) 객체가 null 입니다.");
        }

        // TODO: (!) 임의로 서비스 로직에서 ID를 생성하고 넣어준다.

        // TODO: (!) 상품이 등록된 후에 잘 등록되었는지 검증해야한다.
        //           입력한 상품과 등록된 상품이 일치하는지 검증한다.

        System.out.println("BookList에 상품을 저장합니다." + book);
        bookList.add(book);

        System.out.println("저장된 첫번째 상품 " + bookList.getFirst());

        return book; // 생성된 상품(책)을 반환한다.
    }

    // 상품 수정
    public void update_product() {

    }


    // 상품 전체 조회
    public List<Book> findAll_products() {

        System.out.println("== [Service] 상품 전체 조회 ==");

        return bookList;
    }

    // 상품 상세 조회
    public Book findById_product(Long id) {

        System.out.println("== [Service] 상품 단일 조회 ==");

        // 예외 처리
        if (id == null) {
            System.out.println("[Service Error] 삭제하려는 id가 null 입니다.");
        }

        // booklist에서 가져와야한다.
        // 지금은 bookList의 인덱스를 가져온다.
        // id가 not null이고 list 배열보다 작다면 리스트의 인덱스를 반환한다.
        if (id != null && id <= bookList.size()) {

            System.out.println("단일 조회 객체 : " + bookList.get(id.intValue() - 1));

            return bookList.get(id.intValue() - 1);
        }

        System.out.println("조회에 실패했습니다!!!");

        return null;
    }

    // 상품 삭제
    public void delete_product(Long id) {

        System.out.println("== [Service] 단일 상품 조회 ==");

        System.out.println("삭제할 객체 : " + findById_product(id));

        // 삭제
        var deleteProduct = findById_product(id);
        bookList.remove(deleteProduct);

        System.out.println(id + "삭제 완료!!!");
    }

    // 판매 상태 체크 (?)
    public void check_product_State() {

        // 현재 상태가 판매, 품절 , 판매 대기인지 확인한다.
    }

    // 재고 상태 체크
    public void check_inventory() {

        // 재고는 0보다 작을 수 없다.
    }
}
