## 자바 스프링


## 1일차
<details>
<summary>스프링 프레임워크란?</summary>
<h3>1. 스프링 프레임 워크란?</h3>
Spring Framework

1. 의존 주입(Dependency Inject : DI)
    - 의존성 (Dependency)<br>
        - 객체지향적인 관리 / 객체 관리
2. AOP(Aspect-Oriented Programming) 지원 : 프록시(Proxy)
3. MVC 웹 프레임워크 제공
4. JDBC, JPA 연동, 선언적 트랜잭션 처리 등 DB 연동 지원
    - JPA(Java Persistence API - ORM 표준 설계)
5. 스프링 데이터,  스프링 시큐리티, 스프링 배치

<h3>2. 스프링 프로젝트 생성하기</h3>
- spring-context<br>

<h3>3. 스프링은 객체 컨테이너</h3>
1. IoC - Inversion Of Control : 제어의 역전
    - 개발자가 해야되는 객체의 관리 -> 스프링 컨테이너가 대신 수행
2. 다양한 방식으로 객체 관리
    - 모든 관리 객체가 싱글턴 객체(동일 객체)

<h3>4. 스프링 DI(Dependency Injection - 의존주입)</h3>
1. 의존 (Dependency)
    - 협동, 상호작용
2. DI를 통한 의존 처리
3. DI와 의존 객체 변경의 유연함

<h3>5. 객체 조합기</h3>

<h3>스프링 DI 설정 및 사용</h3>

1. 스프링을 이용한 객체 조립과 사용
2. DI 방식 1 : 생성자 방식
3. DI 방식2 : 세터 메서드 방식
4. @Configuration
5. @Bean
   - getBean
6. 두 개 이상의 설정 파일 사용하기
1) 생성자 매개변수
2) @Import
</details>

<br>

## 2일차
<details>
<summary>의존 자동 주입, 컴포넌트 스캔</summary>

<h3>의존 자동 주입</h3>
1. @Autowired
    - 멤버 변수
    - setter 메서드 : 의존성을 주입, 호출
    - Optional 멤버 변수, setter 메서드의 매개변수
      - @Autowired 애노테이션을 사용하지 않고 자동 주입
         : 컴포넌트 스캔
         : 생성자 매개변수에 의존 객체를 정의, 기본 생성자 X
         : Lombok - @RequiredArgsConstructor

   참고)
   class Optional<T> {
   ....
   private final T value;
   ..
   }

2. 일치하는 빈이 없는 경우
3. @Qualifier
   - 의존성 주입을 할 의존성 객체 지정
4. 빈 이름과 기본 한정자

5. @Autowired 애노테이션의 필수 여부
   required=false : 의존하고 있는 객체가 스프링 컨테이너에 없으면 메서드 호출 X

   @Nullable : setter 메서드는 호출, 의존하는 객체가 없으면 null 을 주입

<h3>컴포넌트 스캔</h3>
   - 지정된 특정 패키지의 범위의 특정 애노테이션이 정의된 클래스를 자동 빈으로 생성
1. @Component
2. @ComponentScan
3. 기본 스캔 대상 - 암기!!!
   - @Component
   - @Service
   - @Inject
   - @Configuration
   - @Controller
   - @RestController
   - @Repository
   - @ControllerAdvice
   - @RestControllerAdvice
   - @Aspect
4. 컴포넌트 스캔에 따른 충돌 처리
* 빈의 이름 클래스명에서 앞자만 소문자 (패키지명은 고려X)
    - 빈 이름 충돌
      - 기본 스캔 대상 애노테이션에 value 속성에 빈의 이름을 직접 지정
    - 수동 등록한 빈과 충돌
      - 수동 등록한 빈이 우선
    - excludeFilters
      - FilterType
        - .ANNOTATION : 특정 애노테이션이 있는 클래스는 스캔범위에서 제외(기본값)
        - .ASSIGNABLE_TYPE : 특정 클래스, 인터페이스 ...
        - .ASPECTJ : ANT 패턴 - aspectjweaver
        - .REGEX : 정규표현식 패턴

<h3>빈 라이프 사이클과 범위</h3>
1. 컨테이너 초기화 : 빈 객체의 생성, 의존 주입, 초기화

2. 컨테이너 종료 : 빈 객체의 소멸

3. 빈 객체의 라이프 사이클
   - 객체 생성 -> 의존 설정 -> 초기화 -> 소멸
   - InitializingBean 인터페이스
     - afterPropertiesSet(....) : 초기화 단계 호출
   - DisposableBean
     - destroy() : 소멸 단계 전에 호출
       - 자원해제에 대한 처리를 주로 정의...
> 직접 정의한 클래스에서만 사용 가능

4. 빈 객체의 초기화와 소멸 : 커스텀 메서드
   - initMethod
   - destroyMethod

5. 빈 객체의 생성과 관리 범위
    - 싱글톤 : 기본<br>
@Scope
    - singleton : 기본값
    - prototype : 객체를 조회할 때마다 새로운 객체를 생성
</details>
<details>
<summary>2일차 정리</summary>
1. 의존성 자동 주입 - @Autowired

    1) 멤버 변수
    2) setter 메서드
    3) Optional
    4) @Autowired 애노테이션을 사용하지 않고 의존성 주입
        - 컴포넌트 스캔으로 자동 빈
        - 생성자 매개변수 + 기본 생성자 X
        - Lombok::@RequiredArgsConstructor
            - 멤버 변수가 final이고 초기화 X
            - @NonNull
<h3>기본 스캔 범위 애노테이션</h3>
    - @Component<br>
    - @Service<br>
    - @Inject<br>
    - @Configuration<br>
    - @Controller<br>
    - @RestController<br>
    - @Repository<br>
    - @ControllerAdvice<br>
    - @RestControllerAdvice<br>
    - @Aspect
</details>