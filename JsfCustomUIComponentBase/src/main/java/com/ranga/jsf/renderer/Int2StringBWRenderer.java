package com.ranga.jsf.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

import com.ranga.jsf.component.Int2StringComponent;

@FacesRenderer(componentFamily = Int2StringComponent.COMPONENT_FAMILY, rendererType = "com.ranga.jsf.renderer.Int2StringBWRenderer")
public class Int2StringBWRenderer extends Renderer {
	public static final String RENDERER_TYPE = "com.ranga.jsf.renderer.Int2StringBWRenderer";

	public Int2StringBWRenderer() {
		super();
		System.out.println("Int2StringBWRenderer");
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component)
			throws IOException {
		System.out.println("Int2StringBWRenderer::encodeEnd");
		ResponseWriter writer = context.getResponseWriter();

		if (component instanceof Int2StringComponent) {
			Int2StringComponent custComponent = (Int2StringComponent) component;

			if (custComponent.isAnyError()) {
				writer.write("*");
			}

			writer.write(custComponent.getResult());
		}
	}

}
