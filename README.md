# JAP_Practice
회사에서는 MyBatis만을 사용하는 프로젝트를 지속적으로 해오고 있습니다.
그러나 JPA는 객체지향적 개발에서 필수로 자리잡은 기술인 만큼 꼭 필요하다는 느낌을 계속 받고 있습니다.
해서 본격적으로 학습 해보려고 합니다.

## 학습목표
- SpringBoot를 기반으로 하여 Spring Framework의 JPA를 활용하여 데이터 엑세스 객체를 생성.
- 단, TDD를 적용하여 구현할 것.

## 학습방법
- 자바 ORM 표준 JPA 프로그래밍 김영한 1독 
- 각각의 파트 요약정리 하여 불로깅
- 연습문제 풀면서 숙달

## 개발환경
- JAVA 17
- gradle

# 도서 내 연습문제
## 1. 요구분석과 기본 매핑
Java Conig가 익숙하지 않아 고초를 겪었습니다. 별도의 설정이 없을 시 Java Config 파일을 기준으로 
@Entity와 같은 애노테이션을 스캔하여 동작하게 되는데 이에 대한 이해의 부재로 별도의 패키지 폴더에 옮겨 놓게 되었고, 
이로인해 해당 엔터티 빈이 등록되지 않았다는 경고를 확인할 수 있었습니다. Java Config를 상단으로 다시 옮겨 실행하여 해결하였습니다.

## 2. 연관관계 맵핑 시작
- Many 쪽이 외래키를 가져갈 수 있게 하는 구조는 쉽게 이해가 되었습니다.
- 연관관계 편의 메서드의 경우, 양방향 관계에서 사용되며 본래 양쪽의 엔터티를 각각 연결시켜야 되는 부분을 하나의 메서드에 포함 되도록 구현한 것입니다.
- 양방향과 단방향의 개념이 낯설게 다가왔습니다. 특히 item과 orderItem사이의 단방향 관계는 좀 더 깊은 이해가 필요해 보입니다.
- @GeneratedValue의 경우 DB에 도달해야만 값을 가져올 수 있어 주석으로 적용을 해제해 놨습니다. 대신 id 값을 하드코딩으로 직접 입력하여 테스트를 더 편하게 할 수 있었습니다. 테스트를 통해 결과를 검증하니 더 명확하고 확실히 넘어 갈 수 있는 것 같습니다.
### Order와 Member를 함께 저장할 때 에러
- object references an unsaved transient instance - save the transient instance before flushing
- 해당 에러는 외래키로 상호 관계 되어있는 엔터티 사이에 부모객체가 존재하지 않아 생성할 수 없을 때 발생합니다.
- 부모 엔터티에 cascade = CascadeType.ALL 를 추가해주면 함께 생성될 수 있어 해결 할 수 있습니다.
## 3. 다양한 연관관계 맵핑
- @OneToOne/ @OneToMany / @ManyToMany


### @OneToOne @OneToMany
- mappedBy는 외래키로 설정 되지 않은 엔테티의 컬럼에 표시하여 외래키로 설정된 엔테티의 필드명을 지칭(?)한다. 즉, 연관관계의 주인이 아니라는 표시이다.
- @JoinColumn(name = "외래키") 래키와 필드의 컬럼을 맵핑

### @ManyToMany
- @JoinTable을 사용하여 연관관계 테이블을 생성한다.
- @ManyToMany는 연관관계를 연결 해주기 위해 연결테이블을 생성하여 관리되지만 필드가 추가될 경우 사용 할 수 없어 실무에서 사용하기 어려움

### 기타
- @Enumerated를 사용하면 해당 칼럼이 Enum 타입을 사용하도록 지정 할 수 있다.

## 4. 상속 관계 맵핑
### @Inheritance
stratagy: InheritanceType.SINGLE_TABLE : 하나의 테이블에 컬럼을 별개로 처리
### @DiscriminatorColumn
name: 구분자로 사용할 컬럼을 설정
### @DiscriminatorValue("구분자")
자식 엔터티에 extends로 부모를 상속 받고, @DiscrinatorValue로 DTYPE에 해당하는 구분자 값을 표시

### @MappedSuperClass
Entity에 필드값을 상속받 여러 엔터티에서 사용하고 싶을 때 @MappedSuperClass를 표시한 클래스를 생성하여 필드를 구현한 후 각각의 엔터티에서 extends 받아 사용하면 된다.

## 5. 연관관계 관리

## 6. 값 타입 맵핑