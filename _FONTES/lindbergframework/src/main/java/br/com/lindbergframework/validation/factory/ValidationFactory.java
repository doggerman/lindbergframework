package br.com.lindbergframework.validation.factory;

import br.com.lindbergframework.spring.LindbergSpringFactory;
import br.com.lindbergframework.validation.IRequiredFieldValidation;
import br.com.lindbergframework.validation.ICastValidation;
import br.com.lindbergframework.validation.IDateValidation;
import br.com.lindbergframework.validation.IDocumentValidation;
import br.com.lindbergframework.validation.IHasBeNullValidacao;
import br.com.lindbergframework.validation.INotEmptyListValidacao;
import br.com.lindbergframework.validation.INotNullValidacao;
import br.com.lindbergframework.validation.INumberValidation;
import br.com.lindbergframework.validation.IExecutorValidation;

/**
 * F�brica de validadores
 * 
 * 
 * @author Victor Lindberg
 * 
 */
public class ValidationFactory {
	 
	public static final String REQUIRED_FIELD_VALIDATION_BEAN = "requiredFieldValidation";
	public static final String FIELD_REQUIRED_DOES_NOT_ALLOW_INFORMATION_EMPTY_VALIDATION_BEAN = "fieldRequiredDoesNotAllowInformationEmpty";
	public static final String NOT_NULL_VALIDACAO = "notNullValidacao";
	public static final String EXECUTOR_VALIDATION_BEAN = "executorValidation";
	public static final String DOUBLE_VALIDACAO_BEAN = "doubleValidacao";
	public static final String NOT_EMPTY_VALIDACAO_BEAN = "notEmptyListValidacao";
	public static final String HAS_BE_NULL_VALIDACAO_BEAN = "hasBeNullValidacao";
	public static final String NUMBER_GREATER_THAN_ZERO_VALIDATION_BEAN = "numberGreaterThanZeroValidation";
	public static final String CPF_VALIDACAO_BEAN = "cpfValidation";
	public static final String CNPJ_VALIDACAO_BEAN = "cnpjValidation";
	public static final String CPF_CNPJ_VALIDACAO_BEAN = "cpfAndCnpjValidation";
	public static final String DATE_HAS_BE_FUTURE_VALIDACAO_BEAN = "dateHasBeFutureValidation";
	public static final String DATE_HAS_BE_PAST_VALIDACAO_BEAN = "dateHasBePastValidation";
	public static final String DATE_HAS_BE_PRESENT_VALIDACAO_BEAN = "dateHasBePresent";
	public static final String DATE_CAN_NOT_BE_FUTURE_VALIDACAO_BEAN = "dateCanNotBeFutureValidation";
	public static final String DATE_CAN_NOT_BE_PAST_VALIDACAO_BEAN = "dateCanNotBePastValidation";
	public static final String DATE_CAN_NOT_BE_PRESENT_VALIDACAO_BEAN = "dateCanNotBePresentValidation";

	
	private static LindbergSpringFactory springFactory = LindbergSpringFactory.getInstance();
	
	public static IRequiredFieldValidation createRequiredFieldValidation() {
		return springFactory.getBean(
				REQUIRED_FIELD_VALIDATION_BEAN);
	}
	 
	public static IRequiredFieldValidation createFieldRequiredDoesNotAllowInformationEmpty() {
		return springFactory.getBean(
				FIELD_REQUIRED_DOES_NOT_ALLOW_INFORMATION_EMPTY_VALIDATION_BEAN);
	}

	public static INumberValidation createNumberGreaterThanZeroValidation() {
		return springFactory.getBean(
				NUMBER_GREATER_THAN_ZERO_VALIDATION_BEAN);
	}

	public static IHasBeNullValidacao createHasBeNullValidacao() {
		return springFactory.getBean(
				HAS_BE_NULL_VALIDACAO_BEAN);
	}

	public static INotEmptyListValidacao createNotEmptyListValidacao() {
		return springFactory.getBean(NOT_EMPTY_VALIDACAO_BEAN);
	}

	public static INotNullValidacao createNotNullValidacao() {
		return springFactory.getBean(NOT_NULL_VALIDACAO);
	}

	public static ICastValidation<String> createStringToDoubleCastValidacao() {
		return springFactory.getBean(DOUBLE_VALIDACAO_BEAN);
	}
	
	public static <E> IDocumentValidation<E> createCpfValidacao() {
		return springFactory.getBean(CPF_VALIDACAO_BEAN);
	}
	
	public static <E> IDocumentValidation<E> createCnpjValidacao() {
		return springFactory.getBean(CNPJ_VALIDACAO_BEAN);
	}
	
	public static <E> IDocumentValidation<E> createCpfCnpjValidacao() {
		return springFactory.getBean(CPF_CNPJ_VALIDACAO_BEAN);
	}
	
	public static IDateValidation createDateHasBeFutureValidation() {
		return springFactory.getBean(DATE_HAS_BE_FUTURE_VALIDACAO_BEAN);
	}
	
	public static IDateValidation createDateHasBePastValidation() {
		return springFactory.getBean(DATE_HAS_BE_PAST_VALIDACAO_BEAN);
	}
	
	public static IDateValidation createDateHasBePresent() {
		return springFactory.getBean(DATE_HAS_BE_PRESENT_VALIDACAO_BEAN);
	}
	
	public static IDateValidation createDateCanNotBeFutureValidation() {
		return springFactory.getBean(DATE_CAN_NOT_BE_FUTURE_VALIDACAO_BEAN);
	}
	
	public static IDateValidation createDateCanNotBePastValidation() {
		return springFactory.getBean(DATE_CAN_NOT_BE_PAST_VALIDACAO_BEAN);
	}
	
	public static IDateValidation createDateCanNotBePresentValidation() {
		return springFactory.getBean(DATE_CAN_NOT_BE_PRESENT_VALIDACAO_BEAN);
	}
	

	/**
	 * Cria um IExecutorValidation
	 */
	public static IExecutorValidation createExecutorValidation() {
		return springFactory.getBean(EXECUTOR_VALIDATION_BEAN);
	}

	

}
