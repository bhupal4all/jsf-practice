package com.ranga.jsf.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SampleBean {
	Date birthDate = null;

	public SampleBean() {
		birthDate = new Date();
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String action(){
		System.out.println("submitted date" + birthDate);
		return "hello";
	}
}
