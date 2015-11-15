package com.ranga.jsf.tag;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;

public class MessageTagHanlder extends javax.faces.view.facelets.TagHandler {

	public MessageTagHanlder(TagConfig config) {
		super(config);
		System.out.println("MessageTagHanlder ctor");
	}

	@Override
	public void apply(FaceletContext ctx, UIComponent parent)
			throws IOException {
		System.out.println("MessageTagHanlder tag impl");

		TagAttribute bold = getAttribute("bold");
		TagAttribute italic = getAttribute("italic");
		TagAttribute underline = getAttribute("underline");

		Boolean isBold = false, isItalic = false, isUnderline = false;

		if (bold != null)
			isBold = new Boolean(bold.getValue());
		if (italic != null)
			isItalic = new Boolean(italic.getValue());
		if (underline != null)
			isUnderline = new Boolean(underline.getValue());

		TagAttribute value = getAttribute("value");

		StringBuilder outputBuilder = new StringBuilder();

		if (ComponentHandler.isNew(parent)) {
			if (isBold) {
				outputBuilder.append("<b>");
			}
			if (isItalic) {
				outputBuilder.append("<i>");
			}
			if (isUnderline) {
				outputBuilder.append("<u>");
			}

			if (value != null)
				outputBuilder.append(value.getValue());
			else
				outputBuilder.append("default message: Hello World");

			if (isBold) {
				outputBuilder.append("</b>");
			}
			if (isItalic) {
				outputBuilder.append("</i>");
			}
			if (isUnderline) {
				outputBuilder.append("</u>");
			}

			UIOutput output = new UIOutput();
			output.setValue(outputBuilder.toString());
			parent.getChildren().add(output);
		}

		nextHandler.apply(ctx, parent);
	}

}
