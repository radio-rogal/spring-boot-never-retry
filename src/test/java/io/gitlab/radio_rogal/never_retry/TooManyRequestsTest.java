package io.gitlab.radio_rogal.never_retry;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(args = {"OpenFeign", "feign"})
class TooManyRequestsTest extends AbstractFeignTest {

  @Autowired
  TooManyRequestsTest(GitHubService service) {
    this.service = service;
  }

  @Override
  Class<? extends FeignException> expectedExceptionClass() {
    return FeignException.TooManyRequests.class;
  }

  @Override
  String owner() {
    return "tooMany";
  }

  @Override
  String repository() {
    return "requests";
  }

}
