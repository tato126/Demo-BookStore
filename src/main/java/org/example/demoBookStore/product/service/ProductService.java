package org.example.demoBookStore.product.service;

import org.example.demoBookStore.product.entity.Book;
import org.example.demoBookStore.product.entity.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    ProductRepository repository;

    // 상품(Book)을 등록한다.
    public Book registry_product(Book book) {

        System.out.println("== [Service] 상품 등록 ==");

        // 유효성 검사
        // (*) 도서(Book) 생성자에서 필드를 Object.requiredNotNull로 검사할 수 있다.
        if (book == null) {
            throw new IllegalArgumentException("도서 정보가 Null 입니다.");
        }

        // TODO: (!) 상품이 등록된 후에 잘 등록되었는지 검증해야한다.
        //           입력한 상품과 등록된 상품이 일치하는지 검증한다.

        var newBook = repository.save(book);

        System.out.println("상품을 DB에 저장합니다." + book);
        System.out.println("DB에 저장된 상품 ID:" + book.getBookId());

        return newBook; // 생성된 상품(책)을 반환한다.
    }

    // 상품 수정
    // 수정할 대상을 DB에서 조회해서 가져와야 한다.
    public Book update_product(Long id, Book updatedBook) {

        System.out.println("[Service] update_product");

        // (!) 예외처리 필수
        // 1. id가 null 인가요?
        if (id == null) {
            throw new IllegalArgumentException("ID가 null일 수 없습니다.");
        }

        if (updatedBook == null) {
            throw new IllegalArgumentException("수정할 도서 정보가 null 일 수 없습니다.");
        }

        // 2. 수정할 대상이 null 인가요?
        Optional<Book> optionalBook = repository.findById(id);

        if (optionalBook.isPresent()) {

            Book existingBook = optionalBook.get();

            // (!) null 체크 중복 제거는 어떻게 할 수 있을까?
            // 3. 각 필드 업데이트 (null이 아닌 값만)
            if (updatedBook.getBookName() != null) {
                existingBook.setBookName(updatedBook.getBookName());
            }
            if (updatedBook.getAuthor() != null) {
                existingBook.setAuthor(updatedBook.getAuthor());
            }
            if (updatedBook.getPublisher() != null) {
                existingBook.setPublisher(updatedBook.getPublisher());
            }
            if (updatedBook.getIsbn() != null) {
                existingBook.setIsbn(updatedBook.getIsbn());
            }
            if (updatedBook.getBookCategory() != null) {
                existingBook.setBookCategory(updatedBook.getBookCategory());
            }
            if (updatedBook.getPublishDate() != null) {
                existingBook.setPublishDate(updatedBook.getPublishDate());
            }

            // 가격 정보 업데이트 (0이 아닌 경우만)
            if (updatedBook.getRegularPrice() > 0) {
                existingBook.setRegularPrice(updatedBook.getRegularPrice());
            }
            if (updatedBook.getSalePrice() > 0) {
                existingBook.setSalePrice(updatedBook.getSalePrice());
            }
            if (updatedBook.getDiscountRate() >= 0) {
                existingBook.setDiscountRate(updatedBook.getDiscountRate());
            }

            // 재고 정보 업데이트
            if (updatedBook.getProduct() != null) {
                existingBook.setProduct(updatedBook.getProduct());
            }
            if (updatedBook.getMinProduct() != null) {
                existingBook.setMinProduct(updatedBook.getMinProduct());
            }
            if (updatedBook.getMaxProduct() != null) {
                existingBook.setMaxProduct(updatedBook.getMaxProduct());
            }

            // 설명 업데이트
            if (updatedBook.getExplanation() != null) {
                existingBook.setExplanation(updatedBook.getExplanation());
            }


            return repository.save(existingBook);
        } else {
            throw new IllegalArgumentException("ID" + id + "에 해당하는 도서를 찾을 수 없습니다.");
        }
    }

    // 상품 전체 조회
    public List<Book> findAll_products() {

        System.out.println("== [Service] 상품 전체 조회 ==");

        return repository.findAll();
    }

    // 상품 상세 조회
    public Book findById_product(Long id) {

        System.out.println("== [Service] 상품 단일 조회 ==");

        // 예외 처리
        if (id == null) {
            System.out.println("[Service Error] 삭제하려는 id가 null 입니다.");
            return null; // (!) 예외 처리 로직 필요
        }

        // DB에서 조회한다.
        Optional<Book> optionalBook = repository.findById(id);

        // repository.findById(id) 가 null이 아닐경우
        if (optionalBook.isPresent()) {

            Book book = optionalBook.get();

            System.out.println("단일 객체 조회 : " + book);
            return book;
        }

        System.out.println("조회에 실패했습니다!!! ID: " + id);

        return null;
    }

    // 상품 삭제
    public void delete_product(Long id) {

        System.out.println("== [Service] 단일 상품 조회 ==");

        // 예외 처리
        var findProduct = findById_product(id);

        if (findProduct == null) {
            throw new IllegalArgumentException("삭제하려는 상품이 null 입니다.");
        }

        // 삭제
        repository.delete(findProduct);


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
