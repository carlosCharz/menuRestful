package com.wedevol.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Menu Bean
 */

public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty("id")
	private int id;
	@JsonProperty("description")
	private String decription;
	@JsonProperty("active")
	private boolean active;
	@JsonProperty("items")
	private List<Item> items;
	@JsonProperty("submenus")
	private List<Menu> submenus;
	
	public Menu(){
	}

	public Menu(int id, String description, boolean active) {
		this.id = id;
		this.decription = description;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Menu> getSubmenus() {
		return submenus;
	}

	public void setSubmenus(List<Menu> submenus) {
		this.submenus = submenus;
	}
}
