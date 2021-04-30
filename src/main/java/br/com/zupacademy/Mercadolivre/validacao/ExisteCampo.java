package br.com.zupacademy.Mercadolivre.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExisteCampoValidator.class)
public @interface ExisteCampo {

    String message() default "Campo Não Existe";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String atributo();
    Class<?> aClass();

}
