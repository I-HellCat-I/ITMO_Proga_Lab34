package cmh;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE, ElementType.LOCAL_VARIABLE})
@Inherited
public @interface Significance {
    TypeOfSignificance value() default TypeOfSignificance.SEMI_SIGNIFICANT;
}
