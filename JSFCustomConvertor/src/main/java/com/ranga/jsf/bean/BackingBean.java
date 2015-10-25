package com.ranga.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "backingBean", eager = true)
public class BackingBean {
	String creditCardNumber;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public String submitAction(){
		return "results";
	}

}