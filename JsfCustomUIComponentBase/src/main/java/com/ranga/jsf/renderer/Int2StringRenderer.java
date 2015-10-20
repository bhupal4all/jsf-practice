package com.ranga.jsf.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

import com.ranga.jsf.component.Int2StringComponent;

@FacesRenderer(componentFamily = Int2StringComponent.COMPONENT_FAMILY, rendererType = "com.ranga.jsf.renderer.Int2StringRenderer")
public class Int2StringRenderer extends Renderer {
	public static final String RENDERER_TYPE = "com.ranga.jsf.renderer.Int2StringRenderer";

	public Int2StringRenderer() {
		super();
		System.out.println("Int2StringRenderer");
	}

	@Override
	public void encodeBegin(FacesContext context, UIComponent component)
			throws IOException {
		System.out.println("encodebegin");
		super.encodeBegin(context, component);
	}

	@Override
	public void encodeChildren(FacesContext context, UIComponent component)
			throws IOException {
		System.out.println("encodeChildren");
		super.encodeChildren(context, component);
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component)
			throws IOException {
		System.out.println("encodeEnd");
		ResponseWriter writer = context.getResponseWriter();

		if (component instanceof Int2StringComponent) {
			Int2StringComponent custComponent = (Int2StringComponent) component;

			if (custComponent.isAnyError()) {
				writer.startElement("font", custComponent);
				writer.writeAttribute("color", "red", "color");
				writer.write(custComponent.getResult());
				writer.endElement("font");
			} else {
				writer.startElement("b", custComponent);
				writer.write(custComponent.getResult());
				writer.endElement("b");

			}
		}
	}

}
