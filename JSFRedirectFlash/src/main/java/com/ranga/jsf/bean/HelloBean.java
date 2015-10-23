package com.ranga.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

@ManagedBean(name = "helloBean", eager = true)
@RequestScoped
public class HelloBean {
	String message = "Hello World!";
	String flashMessage = "This is Flash Message";
	String keepFlashMessage = "Keeping Message";

	public HelloBean() {
		System.out.println("HelloBean started!");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFlashMessage() {
		return flashMessage;
	}

	public void setFlashMessage(String flashMessage) {
		this.flashMessage = flashMessage;
	}

	public String getKeepFlashMessage() {
		return keepFlashMessage;
	}

	public void setKeepFlashMessage(String keepFlashMessage) {
		this.keepFlashMessage = keepFlashMessage;
	}

	public String processFlashMessage() {
		System.out.println("setting flash message");

		Flash flashContext = FacesContext.getCurrentInstance()
				.getExternalContext().getFlash();
		
		flashContext.put("flashMessage", getFlashMessage());
		flashContext.put("keepFlashMessage", getKeepFlashMessage());
		return "page2";
	}
}