package com.ranga.jsf.component;

import java.io.IOException;
import java.util.Hashtable;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent("com.ranga.jsf.component.Int2StringComponent")
public class Int2StringComponent extends UIComponentBase {
	static Hashtable<Integer, String> dictionary = new Hashtable<Integer, String>();

	static{
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
		return "dictionaryComponent";
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		Boolean valid = false;

		String intStr = (String) getAttributes().get("value");

		if (intStr != null) {
			Integer intValue = new Integer(intStr);

			if (intValue != null) {
				valid = true;
				if (intValue < 10) {
					writer.append("<b>");
					writer.append(dictionary.get(intValue));
					writer.append("</b>");
				} else {
					writer.append("<b><font color='red'>");
					writer.append("Integer Value is &gt; 9 ");
					writer.append("</font></b>");
				}
			}
		}

		if (!valid) {
			writer.append("<b><font color='red'>");
			writer.append("Invalid Integer");
			writer.append("</font></b>");
		}
	}

}
