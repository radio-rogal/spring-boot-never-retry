package io.gitlab.radio_rogal.never_retry;

import static java.util.concurrent.TimeUnit.SECONDS;

import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class SpringBootAndNeverRetryApplication {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.err.println("owner and repository name are required");
      System.exit(1);
    }
    SpringApplication.run(SpringBootAndNeverRetryApplication.class, args);
  }

  @Bean
  public Retryer neverRetry(@Value("${never-retry:true}") boolean neverRetry) {
    return (neverRetry) ? Retryer.NEVER_RETRY : new Retryer.Default(100, SECONDS.toMillis(1), 2);
  }

}
