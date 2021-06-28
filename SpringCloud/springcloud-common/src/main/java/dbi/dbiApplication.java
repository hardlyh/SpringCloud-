package dbi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("dbi.mapper")
@ComponentScan("dbi.*")
public class dbiApplication {

}
