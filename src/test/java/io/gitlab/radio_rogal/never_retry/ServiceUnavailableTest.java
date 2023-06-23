package io.gitlab.radio_rogal.never_retry;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(args = {"OpenFeign", "feign"})
class ServiceUnavailableTest extends AbstractFeignTest {

  @Autowired
  ServiceUnavailableTest(GitHubService service) {
    this.service = service;
  }

  @Override
  Class<? extends FeignException> expectedExceptionClass() {
    return FeignException.ServiceUnavailable.class;
  }

  @Override
  String owner() {
    return "service";
  }

  @Override
  String repository() {
    return "unavailable";
  }

}
