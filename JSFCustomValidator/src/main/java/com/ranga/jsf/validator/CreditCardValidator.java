package com.ranga.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "com.ranga.jsf.validator.CreditCardValidator")
public class CreditCardValidator implements javax.faces.validator.Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		System.out.println("CreditCardValidator.validate: " + value);
		String creditCardNumber = (String) value;
		Integer cc = null;
		try {
			cc = Integer.parseInt(creditCardNumber);
		} catch (NumberFormatException e) {
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Custom Validation Failed.",
					"" + e.getLocalizedMessage()));
		}

		if (cc <= 0) {
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Custom Validation Failed.",
					"Not Valid Credit Card Number"));
		}
	}

}
