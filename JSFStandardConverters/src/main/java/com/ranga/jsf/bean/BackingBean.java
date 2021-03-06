package com.ranga.jsf.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "backingBean", eager = true)
public class BackingBean {

	Double amount;
	Long creditCardNumber;
	Date expiryDate;

	public BackingBean() {
		System.out.println("BackingBean started!");
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		log(amount);
		this.amount = amount;
	}

	public Long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(Long creditCardNumber) {
		log(creditCardNumber);
		this.creditCardNumber = creditCardNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		log(expiryDate);
		this.expiryDate = expiryDate;
	}

	public String submitAction() {
		return "results";
	}

	private void log(Object obj) {
		System.out.println("Value Set as " + obj);
	}
}