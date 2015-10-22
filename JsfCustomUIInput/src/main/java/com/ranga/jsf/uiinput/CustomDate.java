package com.ranga.jsf.uiinput;

import java.io.IOException;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

@FacesComponent(value = "CustomDate")
public class CustomDate extends UIInput implements NamingContainer {
	public static final String CUSTOM_DATE_FAMILY = "javax.faces.NamingContainer";

	@Override
	public String getFamily() {
		return CUSTOM_DATE_FAMILY;
	}

	@Override
	public Object getSubmittedValue() {
		return this;
	}

	@Override
	protected Object getConvertedValue(FacesContext context,
			Object newSubmittedValue) throws ConverterException {
		UIInput dayInput = (UIInput) findComponent("day");
		UIInput monthInput = (UIInput) findComponent("month");
		UIInput yearInput = (UIInput) findComponent("year");

		int day = Integer.parseInt((String) dayInput.getSubmittedValue());
		int month = Integer.parseInt((String) monthInput.getSubmittedValue());
		int year = Integer.parseInt((String) yearInput.getSubmittedValue());

		if (isValidDate(day, month, year)) {
			return new Date(year - 1900, month - 1, day);
		} else {
			throw new ConverterException(
					new FacesMessage(FacesMessage.SEVERITY_FATAL,
							"Invalid date", "Invalid date"));
		}
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		Date date = (Date) getValue();
		UIInput dayComponent = (UIInput) findComponent("day");
		UIInput monthComponent = (UIInput) findComponent("month");
		UIInput yearComponent = (UIInput) findComponent("year");
		dayComponent.setValue(date.getDate());
		monthComponent.setValue(date.getMonth() + 1);
		yearComponent.setValue(date.getYear() + 1900);

		super.encodeBegin(context);
	}

	private static boolean isValidDate(int d, int m, int y) {
		if (d < 1 || m < 1 || m > 12) {
			return false;
		}
		if (m == 2) {
			if (isLeapYear(y)) {
				return d <= 29;
			} else {
				return d <= 28;
			}
		} else if (m == 4 || m == 6 || m == 9 || m == 11) {
			return d <= 30;
		} else {
			return d <= 31;
		}
	}

	private static boolean isLeapYear(int y) {
		return y % 4 == 0 && (y % 400 == 0 || y % 100 != 0);
	}
}
