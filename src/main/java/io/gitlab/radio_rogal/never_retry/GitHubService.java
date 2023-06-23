package io.gitlab.radio_rogal.never_retry;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GitHubService implements CommandLineRunner {

  private static final String ACCEPT = "application/vnd.github+json";
  private static final String VERSION = "2022-11-28";

  private final GitHub service;

  GitHubService(GitHub service) {
    this.service = service;
  }

  @Override
  public void run(String... args) {
    var contributors = service.contributors(ACCEPT, VERSION, args[0], args[1]);

    System.out.println(contributors.getJSONObject(0).toString(2));
  }
}
