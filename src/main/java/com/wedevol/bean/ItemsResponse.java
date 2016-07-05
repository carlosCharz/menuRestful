package com.wedevol.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Items Response: To manage list of items of a menu. It can manage filters.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsResponse extends StateResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("items")
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
