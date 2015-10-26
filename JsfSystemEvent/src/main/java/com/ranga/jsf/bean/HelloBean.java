package com.ranga.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean(name = "helloBean", eager = true)
public class HelloBean {
	String message = "Hello World";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HelloBean() {
		System.out.println("HelloBean started!");
	}
	
	public void preRenderViewListener(ComponentSystemEvent event){
		System.out.println("Before Render "+event.getSource().getClass());
	}
}