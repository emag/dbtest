package dbtest.api;

import dbtest.App;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({
  "server.port:0",
})
public class EchoResourceTest {

  @Value("${local.server.port}")
  int port;
  String apiEndPoint;
  RestTemplate restTemplate = new TestRestTemplate();

  @Before
  public void setUp() throws Exception {
    apiEndPoint = "http://localhost:" + port + "/api/echo";
  }

  @Test
  public void echo() throws Exception {
    // Setup
    String message = "Foo";
    URI targetUrl = UriComponentsBuilder.fromUriString(apiEndPoint)
      .queryParam("message", message)
      .build().toUri();
    // Exercise
    ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
    // Verify
    assertThat(response.getStatusCode(), is(HttpStatus.OK));
    assertThat(response.getBody(), is("Hi, " + message));
  }

}