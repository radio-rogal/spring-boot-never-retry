# Spring Boot and NEVER_RETRY

This project references to the issue [Feign retries event if Retryer.NEVER_RETRY is configured in the AsyncFeign.<HttpClientContext>builder()](https://github.com/OpenFeign/feign/issues/1966)

## How to run

First build it. It runs two tests **503 Service Unavailable** and **429 Too Many Requests** with the retryer `NEVER_RETRY`.

```bash
./mvnw
```
You can check in log that the application does not retry requests.

You can set the retryer `Default` with option `maxAttempts` equals **2**.

```bash
NEVER_RETRY=false ./mvnw
```
For tests it uses [MockServer](https://mock-server.com), see the configuration [github-initializer.json](src/test/resources/github-initializer.json).

## Just for fun

This application in regular life shows first contributor for any GitHub repository:

```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments=radio-rogal\ feign
```
or just

```bash
./test.sh radio-rogal feign
```

