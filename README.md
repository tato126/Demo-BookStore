# Demo-BookStore 📚

온라인 서점 관리 시스템 (Online Bookstore Management System)

## 📋 프로젝트 소개

Demo-BookStore는 Spring Boot 기반의 온라인 서점 관리 시스템입니다. 관리자가 도서 상품, 회원, 주문을 효율적으로 관리할 수 있는 웹 애플리케이션으로, MVC 패턴을 적용하여 개발되고 있습니다.

### 주요 특징
- 관리자 중심의 백오피스 시스템
- 도서 상품 통합 관리
- 회원 및 주문 관리 기능
- 반응형 웹 디자인

## 🛠 기술 스택

### Backend
- **Framework**: Spring Boot 3.5.5
- **Language**: Java 21
- **Build Tool**: Gradle
- **Dependencies**: 
  - Spring Web
  - Spring Boot DevTools
  - Lombok

### Frontend
- **Template Engine**: Thymeleaf
- **CSS Framework**: Bootstrap 5.1.3
- **JavaScript**: Vanilla JS

### Database (예정)
- H2 Database (개발환경)
- MySQL (운영환경)

## 📁 프로젝트 구조

```
src/
├── main/
│   ├── java/org/example/demoBookStore/
│   │   ├── admin/
│   │   │   ├── controller/      # 관리자 컨트롤러
│   │   │   │   ├── login/       # 로그인 관련
│   │   │   │   └── product/     # 상품 관리
│   │   │   ├── entity/          # 관리자 엔티티
│   │   │   └── service/         # 관리자 서비스
│   │   ├── product/
│   │   │   ├── dto/             # 상품 DTO
│   │   │   ├── entity/          # 상품 엔티티
│   │   │   └── service/         # 상품 서비스
│   │   ├── user/                # 사용자 관련
│   │   └── dto/                 # 공통 DTO
│   └── resources/
│       ├── templates/           # Thymeleaf 템플릿
│       │   ├── admin-*.html     # 관리자 페이지
│       └── application.properties
└── test/
```

## 📊 현재 진행 상황 (2025-08-30 기준)

### ✅ 완료된 작업
- Spring Boot 프로젝트 초기 설정
- MVC 패턴 기본 구조 구축
- 관리자 UI 전체 구조 구현 (8개 페이지)
  - 로그인 페이지
  - 메인 대시보드
  - 회원/상품/주문 관리 페이지
  - 상세 조회 페이지들
- 상품 등록 폼 구현
- 관리자 로그인/로그아웃 기능
- DTO 클래스 정의 (Book, Admin, User)
- 기본 Controller/Service 구조 설정

### 🔄 진행 중인 작업
- 데이터베이스 연동 준비
- Service 레이어 비즈니스 로직 구현
- Form 데이터 바인딩 최적화

### ⏸️ 대기 중인 작업
- JPA Entity 설정 및 Repository 구현
- 실제 CRUD 기능 구현
- Spring Security 적용
- 테스트 코드 작성

## 💡 주요 기능

### 1. 관리자 인증 시스템
- 로그인/로그아웃 기능
- 세션 관리 (예정)
- 권한 기반 접근 제어 (예정)

### 2. 상품(도서) 관리
- 도서 등록/수정/삭제
- 도서 목록 조회 및 검색
- 재고 관리
- 카테고리별 분류

### 3. 회원 관리
- 회원 목록 조회
- 회원 상세 정보 확인
- 회원 등급 관리
- 주문 이력 조회

### 4. 주문 관리
- 주문 목록 조회
- 주문 상태 관리
- 주문 상세 정보 확인
- 배송 정보 관리

### 5. 대시보드
- 실시간 통계 정보
- 최근 주문 현황
- 매출 현황
- 재고 알림

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

### 테스트 계정
- **ID**: admin
- **Password**: admin123

## 📈 개발 로드맵

### 우선순위 높음 (!)
- [ ] 데이터베이스 연동
  - [ ] H2 Database 설정
  - [ ] JPA Entity 매핑
  - [ ] Repository 인터페이스 구현
- [ ] 핵심 CRUD 기능 구현
  - [ ] 상품 등록/조회/수정/삭제
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
| UI/UX 디자인 | 80% | 🔄 진행중 |
| 관리자 인증 | 60% | 🔄 진행중 |
| 상품 관리 | 40% | 🔄 진행중 |
| 회원 관리 | 30% | ⏸️ 대기 |
| 주문 관리 | 30% | ⏸️ 대기 |
| 데이터베이스 | 10% | ⏸️ 대기 |
| 테스트 | 0% | ⏸️ 대기 |

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

- 현재 개발 초기 단계로 대부분의 서비스 레이어 메서드가 스켈레톤 상태입니다.
- 데이터베이스 연동이 완료되지 않아 실제 데이터 처리는 불가능합니다.
- 테스트 계정을 통한 UI 네비게이션 테스트만 가능합니다.

## 👥 기여자

- **chan** - 프로젝트 리드 개발자

## 📄 라이센스

이 프로젝트는 개인 학습 및 포트폴리오 목적으로 개발되었습니다.

---

**Last Updated**: 2025-08-31