package task6;

import java.lang.annotation.*;

/**
 * Created by glazkina on 11.10.2016.
 */
@SuppressWarnings({"DefaultFileTemplate", "WeakerAccess"})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SubmarineAnnotation {
    String color();
}
