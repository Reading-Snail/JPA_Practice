# JAP_Practice

2023-11-20
현재 회사에서는 MyBatis만을 사용하는 프로젝트를 지속적으로 해오고 있습니다.
또한 앞으로도 동료 개발자들에게 JPA는 매력적인 스택이 아니라고 느껴질 것으로 판단 됩니다.
그러나 JPA는 객체지향적 개발에서 필수로 자리잡은 기술인 만큼 꼭 필요하다는 느낌을 계속 받고 있습니다.
해서 본격적으로 공부를 시작해보려고 합니다.

## 학습목표
- SpringBoot를 기반으로 하여 Spring Framework의 JPA를 활용하여 데이터 엑세스 객체를 생성.
- 단, TDD를 적용하여 구현할 것.

# 학습내용

## 의존성 추가
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

## Entity 클래스
- @Entity가 붙은 클래스는 JPA가 관리하는 클래스가 된다. 
- 테이블과 매핑할 테이블은 해당 어노테이션을 붙인다. 
- 클래스의 필드 변수들은 테이블의 컬럼이 된다.
- 
2) mbrNo 필드는 @id 를 사용하여 기본키(PK)로 지정한다. - Table 생성시 해당 필드를 PK, AUTO_INCREMENT로 설정하였기때문에 직접할당 방식이 아닌, 자동으로 생성되도록 하기위해 @GeneratedValue를 사용한다.  - GenerationType.IDENTITY는 기본 키 생성을 데이터베이스에 위임하는 방식이다.  - @GeneratedValue는 여러 strategy가 있다. 이부분은 추후 자세히 포스팅 하도록 할 예정이니 이번엔 IDENTITY로 설정하자. (IDENTITY, SEQUENCE, TABLE, AUTO 등이 있다.)
                                                                    
## Repository 클라스

## Service 클래스

## Controller 클래스

## 

출처: https://goddaehee.tistory.com/209 [갓대희의 작은공간:티스토리]