# JAP_Practice
2023-11-20
현재 회사에서는 MyBatis만을 사용하는 프로젝트를 지속적으로 해오고 있습니다.
또한 앞으로도 동료 개발자들에게 JPA는 매력적인 스택이 아니라고 느껴질 것으로 판단 됩니다.
그러나 JPA는 객체지향적 개발에서 필수로 자리잡은 기술인 만큼 꼭 필요하다는 느낌을 계속 받고 있습니다.
해서 본격적으로 공부를 시작해보려고 합니다.

## 학습목표
- SpringBoot를 기반으로 하여 Spring Framework의 JPA를 활용하여 데이터 엑세스 객체를 생성.
- 단, TDD를 적용하여 구현할 것.

## 개발환경
- 

# 학습내용
## 의존성 추가
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

## Entity 클래스 - Board
- @Entity가 붙은 클래스는 JPA가 관리하는 클래스가 된다. 
- 테이블과 매핑할 테이블은 해당 어노테이션을 붙인다. 
- 클래스의 필드 변수들은 테이블의 컬럼이 된다.
                                
## Repository 클래스 - BoardRepository


## Service 클래스 - BoardService


## Controller 클래스 - BoardApiController


# 번외 학습
## httpClient를 이용한 RESTAPI 조작
## IntelliJ의 데이터베이스 관리 기능






출처: 
- https://velog.io/@nyong_i/JPA%EB%A1%9C-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-CRUD 
