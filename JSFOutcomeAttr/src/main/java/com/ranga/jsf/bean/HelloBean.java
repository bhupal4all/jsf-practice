package com.ranga.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloBean", eager = true)
public class HelloBean {
	Integer[] pageNumbers = { 1, 2, 3 };

	public Integer[] getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(Integer[] pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public String getOutcomeProperty(){
		return "page2.xhtml";
	}
}