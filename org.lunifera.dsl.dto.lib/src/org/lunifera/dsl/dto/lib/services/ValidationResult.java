package org.lunifera.dsl.dto.lib.services;

import javax.validation.ConstraintViolation;

public class ValidationResult {

	private final ConstraintViolation<?> originalViolation;
	private final String i18nKey;

	public ValidationResult(ConstraintViolation<?> originalViolation) {
		super();
		this.originalViolation = originalViolation;
		this.i18nKey = originalViolation.getMessageTemplate();
	}

	/**
	 * @return the originalViolation
	 */
	public ConstraintViolation<?> getOriginalViolation() {
		return originalViolation;
	}

	/**
	 * @return the i18nKey
	 */
	public String getI18nKey() {
		return i18nKey;
	}

}
