package com.ranga.jsf.component;

import java.io.IOException;
import java.util.Hashtable;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

@FacesComponent("com.ranga.jsf.component.Int2StringComponent")
public class Int2StringComponent extends UIComponentBase {
	static Hashtable<Integer, String> dictionary = new Hashtable<Integer, String>();
	public static final String COMPONENT_FAMILY = "RangaCustomOutputTags";

	private boolean anyError = false;
	private String result = "";

	public boolean isAnyError() {
		return anyError;
	}

	static {
		System.out.println("Static Block - creating map");
		dictionary.put(1, "One");
		dictionary.put(2, "Two");
		dictionary.put(3, "Three");
		dictionary.put(4, "Four");
		dictionary.put(5, "Five");
		dictionary.put(6, "Six");
		dictionary.put(7, "Seven");
		dictionary.put(8, "Eight");
		dictionary.put(9, "Nine");
		dictionary.put(0, "Zero");
	}

	public Int2StringComponent() {
		System.out.println("Int2StringComponent ctor");
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		Boolean valid = false;

		String intStr = (String) getAttributes().get("value");

		if (intStr != null) {
			Integer intValue = new Integer(intStr);

			if (intValue != null) {
				valid = true;
				if (intValue < 10) {
					setResult(dictionary.get(intValue));
				} else {
					setResult("Integer Value is &gt; 9 ");
					anyError = true;
				}
			}
		}

		if (!valid) {
			setResult("Invalid Integer");
			anyError = true;
		}
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

}
