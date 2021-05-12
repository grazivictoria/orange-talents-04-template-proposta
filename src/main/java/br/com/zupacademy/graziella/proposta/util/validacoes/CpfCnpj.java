package br.com.zupacademy.graziella.proposta.util.validacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {CpfCnpjValidator.class})
@Target({ ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfCnpj {

	 String message() default "{br.com.zupacademy.graziella.proposta.validacoes.CpfCnpj}";
	 
	 Class<?>[] groups() default {};

	  Class<? extends Payload>[] payload() default {};
}
