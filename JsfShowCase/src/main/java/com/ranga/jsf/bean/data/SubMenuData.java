package com.ranga.jsf.bean.data;

public class SubMenuData {
	String menuUrl;
	String displayName;
	String description;

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SubMenuData(String menuUrl, String displayName, String description) {
		this.menuUrl = menuUrl;

		if (displayName == null || displayName.isEmpty())
			this.displayName = menuUrl;
		else
			this.displayName = displayName;

		if (description == null || description.isEmpty())
			this.description = menuUrl;
		else
			this.description = description;
	}
}
