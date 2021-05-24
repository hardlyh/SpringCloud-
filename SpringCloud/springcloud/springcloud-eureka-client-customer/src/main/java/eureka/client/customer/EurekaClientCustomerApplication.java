package eureka.client.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientCustomerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientCustomerApplication.class, args);
	}
}
