package br.com.zupacademy.graziella.proposta.validacoes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.stereotype.Component;

@Component
public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, CharSequence>{

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {

		if(value==null) {
			return true;
		}
		
		CNPJValidator cnpjValidator = new CNPJValidator();
		CPFValidator cpfValidator = new CPFValidator();

		cnpjValidator.initialize(null);
		cpfValidator.initialize(null);

		return cnpjValidator.isValid(value, context)
				|| cpfValidator.isValid(value, context);
		
	}

	
	
}
