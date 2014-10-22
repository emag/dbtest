package dbtest.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yoshimasa Tanabe
 */
@RestController
@RequestMapping("/api/echo")
public class EchoResource {

  @RequestMapping(method = RequestMethod.GET)
  String echo(@RequestParam("message") String message) {
    return String.format("Hi, %s", message);
  }

}
