package org.example.demoBookStore.product.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Book, Long> {

    // 제목으로 찾기
    List<Book> findByBookNameContaining(String bookName);

    // 작가명으로 찾기
    List<Book> findByAuthor(String author);

    // Isbn으로 찾기
    Optional<Book> findByIsbn(Long isbn);

}
