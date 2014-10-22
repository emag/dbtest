package dbtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Yoshimasa Tanabe
 */
@ComponentScan
@EnableAutoConfiguration
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class);
  }

}
