package com.ranga.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloBean", eager = true)
public class HelloBean {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}