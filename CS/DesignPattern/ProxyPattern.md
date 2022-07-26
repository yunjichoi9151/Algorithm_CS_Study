# Proxy Pattern

**Structural Design Pattern**

> 어떤 다른 객체로 접근하는 것을 통제하기 위해 그 객체의 매니저를 제공하는 패턴
> 
>
프록시는 대리자, 대변인이라는 뜻을 가지고 있다.

![Problem_Proxy](./img/ProxyPattern1.png)

![Solution_Proxy](./img/ProxyPattern2.png)

## 프록시 패턴의 구조

![출처 : [https://refactoring.guru/design-patterns/proxy](https://refactoring.guru/design-patterns/proxy)](./img/ProxyPattern3.png)

출처 : [https://refactoring.guru/design-patterns/proxy](https://refactoring.guru/design-patterns/proxy)

### **Service Interface**

- 서비스의 인터페이스를 선언
- 프록시 객체는 서비스 객체와 마찬가지로 이 인터페이스를 따라야함

### **Service**

- 실제 서비스를 제공하는 객체

### **Proxy**

- 실제 서비스 객체를 참조하는 필드가 있어야함
- 서비스 객체로 향하는 요청을 가로채서 먼저 처리
- 프록시가 처리를 마친 후 필요 시 서비스 객체에 요청을 전달
- 일반적으로 프록시가 서비스 객체의 전체 수명주기를 관리

## 대표적인 프록시의 사용 예시

### 초기화 지연(가상 프록시)

- 시스템 리소스를 크게 잡아먹는 서비스 객체
- 시스템 가동시에 객체를 초기화하는 것이 아닌, 필요할 때만 프록시 객체에서 요청을 보내서 서비스 객체를 초기화할 수 있도록 지연

### 접근 제어(보호 프록시)

- 특정 클라이언트만 서비스 객체에 접근할 수 있도록 하려는 경우
- 서비스 객체가 시스템(운영 체제)의 중요한 부분일 경우
- 프록시는 클라이언트의 자격 증명이 기준과 일치할 경우에만 서비스 객체에 요청을 전달

### 원격 서비스의 로컬 실행(원격 프록시)

- 서비스 객체가 원격 서버에 있는 경우
- 프록시는 네트워크를 통해 클라이언트 요청을 전달
- 네트워크 작업의 세부 사항을 프록시가 처리

그 외에도..

### 로깅 요청(로깅 프록시)

- 서비스를 전달하기 전에 요청을 프록시가 기록

### 캐싱 요청(캐싱 프록시)

- 클라이언트 요청의 결과를 캐시하고 이 캐시의 수명 주기를 관리
- 동일한 결과를 생성하는 반복 요청이 있을 때 사용

## 프록시 패턴의 장점

- 사이즈가 큰 객체가 로딩이 되기 전에 프록시를 통해 미리 참조할 수 있다
- 실제 객체의 메소드를 숨기고 인터페이스를 통한 노출이 가능
- 로컬에 있지 않은 객체도 사용할 수 있다
- 원래 객체에의 접근에 대해 사전처리가 가능(초기화 지연, 접근 제어, 로깅, 캐싱 등)

## 프록시 패턴의 단점

- 객체를 생성하기 전에 프록시 객체를 거쳐야하므로, 객체 생성이 잦을 경우 성능저하
- 프록시 내부에서 객체 생성을 위해 스레드 생성, 동기화가 구현되어야 하는 경우 성능이 저하될 수 있다. (멀티 스레드)
- 로직이 난해해져 가독성이 떨어질 수 있다

### 예시

- Spring의 AOP
- 웹서버와 프록시서버