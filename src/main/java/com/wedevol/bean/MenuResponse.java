package com.wedevol.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Menu Response
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuResponse extends StateResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("menu")
	private Menu menu;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
