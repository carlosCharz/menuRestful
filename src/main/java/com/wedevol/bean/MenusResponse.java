package com.wedevol.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Menus Response: To manage list of menus
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MenusResponse extends StateResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("menus")
	private List<Menu> menus;

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}
