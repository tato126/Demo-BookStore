# Demo-BookStore 📚

온라인 서점 관리 시스템 (Online Bookstore Management System)

## 📋 프로젝트 소개

Demo-BookStore는 Spring Boot 기반의 온라인 서점 관리 시스템입니다. 관리자가 도서 상품, 회원, 주문을 효율적으로 관리할 수 있는 웹 애플리케이션으로, MVC 패턴과 JPA를 적용하여 개발되고 있습니다.

### 주요 특징
- 관리자 중심의 백오피스 시스템
- 도서 상품 통합 관리 (CRUD 완성)
- 회원 및 주문 관리 기능
- JPA 기반 데이터 영속성 관리
- 반응형 웹 디자인

## 🛠 기술 스택

### Backend
- **Framework**: Spring Boot 3.5.5
- **Language**: Java 21
- **Build Tool**: Gradle
- **ORM**: Spring Data JPA / Hibernate
- **Dependencies**: 
  - Spring Web
  - Spring Data JPA
  - Spring Boot DevTools
  - Lombok

### Frontend
- **Template Engine**: Thymeleaf + Layout Dialect
- **CSS Framework**: Bootstrap 5.1.3
- **JavaScript**: Vanilla JS

### Database
- **개발환경**: H2 Database (인메모리)
- **운영환경**: MySQL (예정)

## 📁 프로젝트 구조

```
src/
├── main/
│   ├── java/org/example/demoBookStore/
│   │   ├── admin/
│   │   │   ├── controller/      # 관리자 컨트롤러
│   │   │   │   ├── login/       # 로그인 관련
│   │   │   │   └── product/     # 상품 관리
│   │   │   ├── entity/          # Admin 엔티티 & Repository
│   │   │   └── service/         # 관리자 서비스
│   │   ├── product/
│   │   │   ├── entity/          # Book 엔티티 & Repository
│   │   │   └── service/         # ProductService (CRUD 구현)
│   │   ├── user/                # User 엔티티 & Enum
│   │   ├── config/              # DataInitializer
│   │   └── dto/                 # 공통 DTO
│   └── resources/
│       ├── templates/           
│       │   ├── admin/           # 관리자 페이지 (재구성)
│       │   ├── fragments/       # 공통 컴포넌트
│       │   └── layouts/         # 레이아웃 템플릿
│       └── application.properties  # H2 DB 설정
└── test/
```

## 📊 현재 진행 상황 (2025-09-02 기준)

### ✅ 완료된 작업
- Spring Boot 프로젝트 초기 설정
- MVC 패턴 기본 구조 구축
- **JPA/Hibernate 설정 및 H2 Database 연동**
- **Repository 인터페이스 구현 (ProductRepository, AdminRepository)**
- **Book 엔티티 JPA 매핑 완료**
- **ProductService CRUD 메서드 구현**
  - `registry_product()` - 상품 등록
  - `update_product()` - 상품 수정 (부분 업데이트 지원)
  - `findAll_products()` - 전체 조회
  - `findById_product()` - 상세 조회
  - `delete_product()` - 상품 삭제
- **예외 처리 개선 (IllegalArgumentException 활용)**
- 관리자 UI 구조 재편성
  - admin/ 디렉토리 구조로 템플릿 정리
  - 상품 수정 페이지 추가 (product-update.html)
- 관리자 로그인/로그아웃 기능
- DataInitializer를 통한 초기 데이터 설정

### 🔄 진행 중인 작업
- 입력값 검증 로직 강화
- 트랜잭션 관리 (@Transactional)
- 로깅 시스템 도입

### ⏸️ 대기 중인 작업
- Spring Security 적용
- 테스트 코드 작성
- 회원/주문 관리 기능 구현
- RESTful API 문서화

## 💡 주요 기능

### 1. 관리자 인증 시스템
- 로그인/로그아웃 기능 ✅
- 세션 관리 (예정)
- 권한 기반 접근 제어 (예정)

### 2. 상품(도서) 관리 
- **도서 등록** ✅ - JPA save() 활용
- **도서 수정** ✅ - 부분 업데이트 지원
- **도서 삭제** ✅ - Soft/Hard delete 지원
- **도서 목록 조회** ✅ - findAll() 구현
- **도서 상세 조회** ✅ - findById() 구현
- 도서 검색 기능 (예정)
- 재고 관리 (진행중)
- 카테고리별 분류 (예정)

### 3. 회원 관리
- 회원 목록 조회 (예정)
- 회원 상세 정보 확인 (예정)
- 회원 등급 관리 (예정)
- 주문 이력 조회 (예정)

### 4. 주문 관리
- 주문 목록 조회 (예정)
- 주문 상태 관리 (예정)
- 주문 상세 정보 확인 (예정)
- 배송 정보 관리 (예정)

### 5. 대시보드
- 실시간 통계 정보 (예정)
- 최근 주문 현황 (예정)
- 매출 현황 (예정)
- 재고 알림 (예정)

## 🚀 설치 및 실행 방법

### 환경 요구사항
- Java 21 이상
- Gradle 7.x 이상

### 실행 방법

1. 프로젝트 클론
```bash
git clone https://github.com/yourusername/Demo-BookStore.git
cd Demo-BookStore
```

2. 프로젝트 빌드
```bash
./gradlew clean build
```

3. 애플리케이션 실행
```bash
./gradlew bootRun
```

4. 브라우저에서 접속
```
http://localhost:8080/admin/login
```

5. H2 Console 접속 (데이터베이스 확인)
```
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:bookstoredb
Username: sa
Password: (비워두기)
```

### 테스트 계정
- **ID**: admin
- **Password**: admin123

## 🔌 API 엔드포인트

### 상품 관리 API
| Method | Endpoint | Description | Status |
|--------|----------|-------------|--------|
| GET | `/admin/products` | 상품 목록 조회 | ✅ |
| GET | `/admin/products/{id}` | 상품 상세 조회 | ✅ |
| GET | `/admin/products/create` | 상품 등록 폼 | ✅ |
| POST | `/admin/products` | 상품 등록 | ✅ |
| GET | `/admin/products/{id}/edit` | 상품 수정 폼 | ✅ |
| PUT | `/admin/products/{id}` | 상품 수정 | ✅ |
| DELETE | `/admin/products/{id}` | 상품 삭제 | ✅ |

### 관리자 인증
| Method | Endpoint | Description | Status |
|--------|----------|-------------|--------|
| GET | `/admin/login` | 로그인 페이지 | ✅ |
| POST | `/admin/login` | 로그인 처리 | ✅ |
| GET | `/admin/logout` | 로그아웃 | ✅ |
| GET | `/admin/main` | 대시보드 | ✅ |

## 📈 개발 로드맵

### 우선순위 높음 (!)
- [x] 데이터베이스 연동
  - [x] H2 Database 설정
  - [x] JPA Entity 매핑
  - [x] Repository 인터페이스 구현
- [x] 핵심 CRUD 기능 구현 (상품)
  - [x] 상품 등록/조회/수정/삭제
  - [ ] 회원 관리 기능
  - [ ] 주문 처리 기능
- [ ] Spring Security 적용
  - [ ] 실제 인증/인가 구현
  - [ ] 세션 관리
  - [ ] CSRF 보호
- [ ] 입력값 검증
  - [ ] Bean Validation 적용
  - [ ] 에러 처리 및 메시지

### 우선순위 중간 (*)
- [ ] 검색 및 필터링 기능
  - [ ] 상품 검색
  - [ ] 회원 검색
  - [ ] 주문 필터링
- [ ] 페이징 처리
  - [ ] Spring Data JPA Pageable 적용
  - [ ] 프론트엔드 페이지네이션
- [ ] 파일 업로드
  - [ ] 상품 이미지 업로드
  - [ ] 이미지 리사이징
- [ ] 리팩토링
  - [ ] Service 레이어 분리
  - [ ] DTO/Entity 명확한 분리
  - [ ] 공통 코드 모듈화

### 향후 계획
- [ ] RESTful API 구현
- [ ] 테스트 코드 작성 (JUnit5)
- [ ] API 문서화 (Swagger)
- [ ] 로깅 시스템 구축
- [ ] 캐싱 전략 적용
- [ ] 성능 최적화
- [ ] Docker 컨테이너화
- [ ] CI/CD 파이프라인 구축

## 📊 프로젝트 진행률

| 모듈 | 진행률 | 상태 |
|------|--------|------|
| 프로젝트 설정 | 100% | ✅ 완료 |
| 데이터베이스 | 70% | 🔄 진행중 |
| UI/UX 디자인 | 85% | 🔄 진행중 |
| 관리자 인증 | 60% | 🔄 진행중 |
| 상품 관리 | 80% | 🔄 진행중 |
| 회원 관리 | 10% | ⏸️ 대기 |
| 주문 관리 | 10% | ⏸️ 대기 |
| 테스트 | 0% | ⏸️ 대기 |

## 💻 코드 예제

### 상품 수정 메서드 (부분 업데이트 패턴)
```java
public Book update_product(Long id, Book updatedBook) {
    // 파라미터 검증
    if (id == null) {
        throw new IllegalArgumentException("ID가 null일 수 없습니다.");
    }
    
    Optional<Book> optionalBook = repository.findById(id);
    
    if (optionalBook.isPresent()) {
        Book existingBook = optionalBook.get();
        
        // null이 아닌 필드만 선택적 업데이트
        if (updatedBook.getBookName() != null) {
            existingBook.setBookName(updatedBook.getBookName());
        }
        // ... 다른 필드들도 동일하게 처리
        
        return repository.save(existingBook);
    } else {
        throw new IllegalArgumentException("ID" + id + "에 해당하는 도서를 찾을 수 없습니다.");
    }
}
```

### 예외 처리 패턴
```java
// Before: 모호한 에러 처리
if (book == null) {
    System.out.println("도서 객체가 null 입니다.");
    return null;
}

// After: 명시적 예외 처리
if (book == null) {
    throw new IllegalArgumentException("도서 정보가 null일 수 없습니다.");
}
```

## 🔍 개발 규칙

### 코드 주석 규칙
- `(!)` : 우선적으로 개발해야 함
- `(~)` : 우선순위에서 밀려남
- `(?)` : 해당 기능의 필요성 검토 필요
- `(*)` : 향후 발전 가능한 기능

### 브랜치 전략
- `master` : 메인 브랜치
- `develop` : 개발 브랜치
- `feature/*` : 기능 개발 브랜치
- `hotfix/*` : 긴급 수정 브랜치

## 📝 참고사항

- H2 인메모리 데이터베이스를 사용하여 서버 재시작 시 데이터가 초기화됩니다.
- DataInitializer를 통해 서버 시작 시 샘플 데이터가 자동으로 생성됩니다.
- 상품 관리 CRUD 기능이 완성되어 실제 데이터 처리가 가능합니다.
- 회원 및 주문 관리 기능은 아직 구현 중입니다.

## 🔄 최근 변경사항 (2025-09-02)

- ✨ ProductService update_product 메서드 완성
- ✨ 예외 처리 개선 (IllegalArgumentException 활용)
- ✨ JPA Repository 패턴 구현
- ✨ H2 Database 연동 및 설정 완료
- ✨ 템플릿 구조 재편성 (admin/ 디렉토리)
- ✨ 부분 업데이트 패턴 적용

## 👥 기여자

- **chan** - 프로젝트 리드 개발자

## 📄 라이센스

이 프로젝트는 개인 학습 및 포트폴리오 목적으로 개발되었습니다.

---

**Last Updated**: 2025-09-02