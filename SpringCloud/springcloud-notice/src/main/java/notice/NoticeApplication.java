package notice;

import log.LogUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//EnableEurekaClient
@SpringBootApplication
public class NoticeApplication {

	@Value("${server.port}")
	public  String name;
	public static void main(String[] args) {

		SpringApplication.run(NoticeApplication.class, args);
		LogUtil.info("name2 : " + new NoticeApplication().name);
	}

}
