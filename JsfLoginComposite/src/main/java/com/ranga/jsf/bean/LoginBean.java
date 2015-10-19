package com.ranga.jsf.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBean", eager = true)
public class LoginBean {
	String username;
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginBean() {
		System.out.println("Login Bean Created");
	}

	public String loginAction() {
		System.out.println("Login Action Called");
		if (username != null && username.equals(password))
			return "authorized";
		else {
			// Adding Error Message to Context
			FacesMessage errMsg = new FacesMessage("Authentication Failed",
					"Username/Password is Invalid");
			FacesContext.getCurrentInstance().addMessage(null, errMsg);
			return "";
		}
	}
}