package io.gitlab.radio_rogal.never_retry;

import org.json.JSONArray;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "github")
interface GitHub {

  @RequestMapping("/repos/{owner}/{repo}/contributors")
  JSONArray contributors(@RequestHeader("Accept") String accept,
      @RequestHeader("X-GitHub-Api-Version") String version, @PathVariable String owner,
      @PathVariable String repo);

}
