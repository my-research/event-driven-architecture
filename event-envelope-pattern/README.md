# Event Envelope Pattern

![image](https://user-images.githubusercontent.com/48385288/183649586-c283bb2c-85b4-4e68-8cf8-e5f748d9f850.png)

> [https://developer.confluent.io/patterns/](https://developer.confluent.io/patterns/) 에서 소개된 Event Envelope Pattern 에 대해서 실습합니다.

# 설명

- Event Stream Platform 은 여러 유형의 서로 다른 애플리케이션에서 동작할 수 있게 해준다.
    - standardize
    - general
- Event Envelope Pattern 은 Event Streaming Application 사이에서 전송되는 모든 Event 에 대해서 General 한 데이터 구조를 제공한다.
- Event Envelope 은 어떠한 이벤트 형식과도 독립적이다.
- Event Envelope 에 암호화를 걸 수도 있고 부가적인 정보를 표준화하여 전송/수신할 수 있게 한다
    - TCP-IP 와 같은 Networking Protocol Header와 유사하다

### Problem

- How can I convey information to all participants in an Event Streaming Platform independently of the event payload?
- For example, how can I convey how to decrypt an Event, what schema is used, or what ID defines the uniqueness of the event?

# System Components

- **Order Service**
    - event publisher
- **Delivery Service**
    - event consumer
- messaing
    - infra : ~~rabbitmq~~ AWS SQS

### run rabbit mq

```shell
docker run -d --hostname my-rabbit --name some-rabbit rabbitmq:3
```

### References

- [https://spring.io/guides/gs/messaging-rabbitmq/](https://spring.io/guides/gs/messaging-rabbitmq/)
- [https://developer.confluent.io/patterns/](https://developer.confluent.io/patterns/)
- [https://www.rabbitmq.com/tutorials/tutorial-one-java.html](https://www.rabbitmq.com/tutorials/tutorial-one-java.html)