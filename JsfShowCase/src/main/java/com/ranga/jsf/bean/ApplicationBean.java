package com.ranga.jsf.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.ranga.jsf.bean.data.SubMenuData;

@ManagedBean(eager = true, name = "appBean")
@ApplicationScoped
public class ApplicationBean {
	List<SubMenuData> submenu = new ArrayList();
	Locale locale = null;
	ResourceBundle bundle = null;

	public ApplicationBean() {
		FacesContext fctx = FacesContext.getCurrentInstance();
		Application app = fctx.getApplication();

		try {
			bundle = app.getResourceBundle(fctx, "gmsg");
			String[] menuArray = bundle.getString("submenu").split(";");
			for (String submenustring : menuArray) {
				String[] submenuarray = submenustring.split(",");
				if (submenuarray.length == 3) {
					submenu.add(new SubMenuData(submenuarray[0],
							submenuarray[1], submenuarray[2]));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SubMenuData> getSubmenu() {
		return submenu;
	}

	public void setSubmenu(List<SubMenuData> submenu) {
		this.submenu = submenu;
	}

	public ResourceBundle getBundle() {
		return bundle;
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}
}
