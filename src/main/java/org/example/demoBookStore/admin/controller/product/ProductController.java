package org.example.demoBookStore.admin.controller.product;

import org.example.demoBookStore.product.entity.Book;
import org.example.demoBookStore.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 관리자(Admin) 상품(Product) 화면 호출을 관리한다.
 * <p>
 * (!)는 우선적으로 개발해야함을 의미한다.
 * (~)는 우선순위에서 보다 밀려난 것을 의미한다.
 * (?)는 해당 객체에 필요한 기능인가를 의미한다.
 * (*)은 향후 발전 가능 기능을 의미한다.
 *
 * @author chan
 */
@RequestMapping("/admin/product")
@Controller
public class ProductController {

    @Autowired
    ProductService bookService;

    // 상품 관리 페이지로 이동
    @GetMapping
    public String move_productPage(Model model) {

        System.out.println("== [Controller] 상품 관리 페이지로 이동 ==");

        // 상품 조회
        // 상품 조회는 어떻게 할까?
        // 상품 리스트를 다 읽어와서 model로 보내줘야할 것 같다.
        System.out.println("[Controller] 등록된 모든 상품을 조회한다.");

        List<Book> bookList = bookService.findAll_products();

        model.addAttribute("bookList", bookList);

        return "admin/products";
    }

    // 어드민이 상품을 등록한다.
    // TODO: 현재 뷰에서 필드 입력을 하여도 book 객체가 넘어오지 않는다. Debugging 을 해보자
    @PostMapping("/create")
    public String create_productProcess(Book newBook) {

        System.out.println("== [Controller] 상품 등록 프로세스 ==");

        // 등록한 도서 유효성 검사
        // 상품이 null일 경우 예외 발생 후 리다이렉트
        if (newBook == null) {
            System.out.println("[Error] 도서(상품)을 등록 중에 에러 발생!");
            System.out.println("도서는 null 일 수 없습니다.");

            return "redirect:/admin/product/create";
        } else {
            System.out.println("등록된 도서 " + newBook.toString());
        }

        bookService.registry_product(newBook);

        return "redirect:/admin/product";
    }

    // 상품 상세 조회
    // GetMapping("/product/{id}")
    // PathVariable
    @GetMapping("/detail/{id}")
    public String detail_상품리스트(@PathVariable("id") Long id, Model model) {

        // 상품 상세 정보를 가져온다.
        System.out.println("== [Controller] 관리자 상품 상세 페이지 ==");

        System.out.println("== 조회한 상품 id: " + id);

        Book book = bookService.findById_product(id);

        if (book == null) {
            System.out.println("[Controller] 서비스에서 조회한 단일 id 객체가 null 입니다.");
            return "redirect:/admin/product/main";
        }

        model.addAttribute("book", book);

        // 조회한 객체
        System.out.println(model.getAttribute("book"));

        return "admin/product-detail";
    }

    // 상품 등록 페이지로 이동
    @GetMapping("/create")
    public String create_productPage() {

        System.out.println("== [Controller] 상품 등록 페이지로 이동 ==");

        return "admin/product-create";
    }

    // 상품 수정 페이지 GET
    @GetMapping("/update/{id}")
    public String update_productPage(@PathVariable("id") Long id, Model model) {

        System.out.println("== [Controller] 상품 업데이트 화면으로 이동 ==");

        // 수정할 상품 조회
        Book book = bookService.findById_product(id);

        // 유효성 상품 조회
        if (book == null) {
            System.out.println("[Controller] 수정할 상품을 찾을 수 없습니다.");
            return "redirect:/admin/product";
        }

        // Model에 book
        model.addAttribute("book", book);

        return "admin/product-update";
    }

    // 상품 수정
    // 해당 상품의 id를 조회한다.
    // 해당 id의 상품을 찾아온다.
    // 수정하는 화면으로 이동한다.
    // 화면에 데이터를 수정한다.
    @PostMapping("/update/{id}")
    public String update_productProcess(@PathVariable("id") Long id, Book updateBook) {

        System.out.println("== [Controller] 상품 업데이트 ==");

        var result = bookService.update_product(id, updateBook);

        // 유효성 검사
        if (result == null) {
            System.out.println("[Controller] 상품 수정 실패");
            return "redirect:/admin/product";
        }

        System.out.println("상품을 업데이트 한다.");

        return "redirect:/admin/product";
    }

    // 상품 삭제
    @PostMapping("/detail/{id}")
    public String delete_productPage(@PathVariable("id") Long id) {

        System.out.println("== [Controller] 상품 삭제 ==");

        // 예외 처리
        if (id == null) {
            System.out.println("삭제하려는 id가 존재하지 않습니다. :" + id + " is null");
        }

        bookService.delete_product(id);

        return "redirect:/admin/product";
    }
}
