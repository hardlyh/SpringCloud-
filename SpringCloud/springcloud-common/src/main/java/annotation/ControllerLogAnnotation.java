package annotation;

import java.lang.annotation.*;

/**
 * AOP 实现 Controller层Log
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLogAnnotation {

}
