package com.ranga.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "helloBean", eager = true)
public class HelloBean {
	String debugLevel = "";
	String className = "";

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDebugLevel() {
		return debugLevel;
	}

	public void setDebugLevel(String debugLevel) {
		this.debugLevel = debugLevel;
	}

	public void menuValueChangeEvent(ValueChangeEvent event) {
		System.out.println("menuValueChangeEvent\n\tOld Value="
				+ event.getOldValue() + "\n\tNew Value=" + event.getNewValue());
	}

	public void textValueChangeEvent(ValueChangeEvent event) {
		System.out.println("textValueChangeEvent\n\tOld Value="
				+ event.getOldValue() + "\n\tNew Value=" + event.getNewValue());
	}
}