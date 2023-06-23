package io.gitlab.radio_rogal.never_retry;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import feign.FeignException;
import feign.RetryableException;
import org.junit.jupiter.api.Test;

public abstract class AbstractFeignTest {

  protected GitHubService service;

  abstract Class<? extends FeignException> expectedExceptionClass();

  abstract String owner();

  abstract String repository();

  @Test
  protected void contextLoads() {
    // when
    var exception = assertThrows(RetryableException.class, this::sendRequest);

    // then
    assertInstanceOf(expectedExceptionClass(), exception.getCause());
  }

  private void sendRequest() {
    service.run(owner(), repository());
  }

}
