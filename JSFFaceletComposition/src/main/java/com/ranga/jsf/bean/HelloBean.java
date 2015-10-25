package com.ranga.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloBean", eager = true)
public class HelloBean {
	public HelloBean() {
		System.out.println("HelloBean started!");
	}

	public String getMessage() {
		return "Hello World!";
	}

	public String defaultAction() {
		return "";
	}
}