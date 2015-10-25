package com.ranga.jsf.convertor;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "com.ranga.jsf.convertor.CreditCardConvertor")
public class CreditCardConvertor implements javax.faces.convert.Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		System.out.println("CreditCardConvertor.getAsObject: " + value);

		String creditCardNumber = (String) value;
		creditCardNumber = creditCardNumber.trim();
		creditCardNumber = creditCardNumber.replaceAll(" ", "");

		if (creditCardNumber.length() == 0 || creditCardNumber.length() > 16) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Custom Validation Failed.",
					"Credit Card Length is NOT matched for '"
							+ creditCardNumber + "'");

			throw new ConverterException(message);
		}

		return creditCardNumber;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		System.out.println("CreditCardConvertor.getAsObject: " + value);

		String creditCardNumber = (String) value;

		creditCardNumber = creditCardNumber.trim();
		creditCardNumber = creditCardNumber.replaceAll(" ", "");

		return creditCardNumber.toString();
	}

}
