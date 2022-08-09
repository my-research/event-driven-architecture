# Event Envelope Pattern

![image](https://user-images.githubusercontent.com/48385288/183649586-c283bb2c-85b4-4e68-8cf8-e5f748d9f850.png)

> [https://developer.confluent.io/patterns/](https://developer.confluent.io/patterns/) 에서 소개된 Event Envelope Pattern 에 대해서 실습합니다.

# 설명

- 이벤트 스트리밍 플랫폼은 다양한 유형의 애플리케이션이 함께 작동할 수 있게 해준다. 
- 이벤트 봉투는 이벤트 스트리밍 애플리케이션을 통해 전송된 모든 이벤트에서 잘 알려진 표준 필드 세트를 제공합니다. 
- 봉투는 기본 이벤트 형식과 독립적이며, 종종 암호화 유형, 스키마, 키 및 직렬화 형식과 같은 속성을 참조합니다. 
- 봉투는 네트워킹의 프로토콜 헤더(예: TCP-IP)와 유사합니다.

### Problem

- How can I convey information to all participants in an Event Streaming Platform independently of the event payload? 
- For example, how can I convey how to decrypt an Event, what schema is used, or what ID defines the uniqueness of the event?

# Architecture

