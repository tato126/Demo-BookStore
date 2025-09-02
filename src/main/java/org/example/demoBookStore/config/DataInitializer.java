package org.example.demoBookStore.config;

import lombok.RequiredArgsConstructor;
import org.example.demoBookStore.product.entity.Book;
import org.example.demoBookStore.product.entity.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * 데이터 베이스(H2)에 더미 데이터를 추가한다.
 * 실행시 insert 된다.
 *
 * @author chan
 */
@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    // 상품 리포지토리
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        createBookDate();
    }

    private void createBookDate() {

        // 5권의 테스트 도서 생성
        Book book1 = Book.builder()
                .bookName("자바의 정석")
                .author("남궁성")
                .publisher("도우출판")
                .isbn(9788994492032L)
                .bookCategory("프로그래밍")
                .publishDate(LocalDate.of(2016, 1, 27))
                .regularPrice(30000)
                .salePrice(27000)
                .discountRate(10)
                .product(100L)
                .minProduct(10L)
                .maxProduct(200L)
                .explanation("자바 프로그래밍의 기초부터 실무까지 완벽 정리")
                .build();

        Book book2 = Book.builder()
                .bookName("스프링 부트와 AWS로 혼자 구현하는 웹 서비스")
                .author("이동욱")
                .publisher("프리렉")
                .isbn(9788965402602L)
                .bookCategory("프로그래밍")
                .publishDate(LocalDate.of(2019, 11, 29))
                .regularPrice(22000)
                .salePrice(19800)
                .discountRate(10)
                .product(50L)
                .minProduct(5L)
                .maxProduct(100L)
                .explanation("스프링 부트와 AWS를 사용한 웹 서비스 구축 완벽 가이드")
                .build();

        Book book3 = Book.builder()
                .bookName("클린 코드")
                .author("로버트 C. 마틴")
                .publisher("인사이트")
                .isbn(9788966260959L)
                .bookCategory("프로그래밍")
                .publishDate(LocalDate.of(2013, 12, 24))
                .regularPrice(33000)
                .salePrice(29700)
                .discountRate(10)
                .product(75L)
                .minProduct(10L)
                .maxProduct(150L)
                .explanation("애자일 소프트웨어 장인 정신, 깨끗한 코드 작성법")
                .build();

        Book book4 = Book.builder()
                .bookName("이펙티브 자바 3판")
                .author("조슈아 블로크")
                .publisher("인사이트")
                .isbn(9788966262281L)
                .bookCategory("프로그래밍")
                .publishDate(LocalDate.of(2018, 11, 1))
                .regularPrice(36000)
                .salePrice(32400)
                .discountRate(10)
                .product(80L)
                .minProduct(15L)
                .maxProduct(200L)
                .explanation("자바 프로그래밍 언어 활용 모범 사례")
                .build();

        Book book5 = Book.builder()
                .bookName("자바 ORM 표준 JPA 프로그래밍")
                .author("김영한")
                .publisher("에이콘출판")
                .isbn(9788960777330L)
                .bookCategory("프로그래밍")
                .publishDate(LocalDate.of(2015, 7, 28))
                .regularPrice(43000)
                .salePrice(38700)
                .discountRate(10)
                .product(60L)
                .minProduct(10L)
                .maxProduct(120L)
                .explanation("스프링 데이터 예제 프로젝트로 배우는 전자정부 표준 데이터베이스 프레임워크")
                .build();

        // 데이터베이스에 한번에 저장
        productRepository.saveAll(List.of(book1, book2, book3, book4, book5));

        System.out.println("===== 테스트 도서 데이터 생성 완료 =====");
        System.out.println("총 " + productRepository.count() + "권의 도서가 등록되었습니다.");
    }
}
