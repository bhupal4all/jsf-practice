package com.ranga.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "helloBean", eager = true)
public class HelloBean {
	public void defaultActionListener(ActionEvent event) {
		FacesContext fcontext = FacesContext.getCurrentInstance();
		String clientId = event.getComponent().getClientId(fcontext);

		System.out.println("Client Id: " + clientId + "\nFamily : "
				+ event.getComponent().getFamily());

		if (event.getSource() instanceof javax.faces.component.html.HtmlCommandLink) {
			javax.faces.component.html.HtmlCommandLink link = (HtmlCommandLink) event
					.getSource();
			System.out.println("Renderer Type: " + link.getRendererType());
		} else if (event.getSource() instanceof javax.faces.component.html.HtmlCommandButton) {
			javax.faces.component.html.HtmlCommandButton button = (HtmlCommandButton) event
					.getSource();
			System.out.println("Renderer Type: " + button.getRendererType());
		}
	}

	public String defaultAction() {
		System.out
				.println("defaultAction - returning empty string to stay on same page");
		return "";
	}
}