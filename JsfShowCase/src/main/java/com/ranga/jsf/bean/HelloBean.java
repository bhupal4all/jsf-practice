package com.ranga.jsf.bean;

import javax.faces.bean.ManagedBean;

import com.ranga.jsf.bean.data.SubMenuData;

@ManagedBean(name = "helloBean", eager = true)
public class HelloBean {
	SubMenuData submenu = new SubMenuData("dummy", "", "");

	public HelloBean() {
		System.out.println("HelloBean started!");
	}

	public String getMessage() {
		return "Hello World!";
	}

	public SubMenuData getSubmenu() {
		return submenu;
	}

	public void setSubmenu(SubMenuData submenu) {
		this.submenu = submenu;
	}

}