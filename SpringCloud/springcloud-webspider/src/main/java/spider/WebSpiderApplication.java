package spider;

import log.LogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import utils.RequestUtil;

@EnableEurekaClient
@SpringBootApplication
public class WebSpiderApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSpiderApplication.class, args);
	}
}
