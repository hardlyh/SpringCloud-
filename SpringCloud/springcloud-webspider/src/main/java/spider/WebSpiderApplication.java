package spider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WebSpiderApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSpiderApplication.class, args);
	}
}
