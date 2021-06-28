package annotation;

import java.lang.annotation.*;

/**
 * AOP 实现 Controller层Log
 *
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLogAnnotation {

}
