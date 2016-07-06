package com.wedevol.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wedevol.util.Util;

/*
 * Item of a Menu
 */

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("photo")
	private byte[] photo;
	@JsonProperty("days")
	private List<WeekDay> days;
	@JsonProperty("dateFrom")
	@JsonFormat(pattern=Util.DATE_FORMAT)
	private Date dateFrom;
	@JsonProperty("dateTo")
	@JsonFormat(pattern=Util.DATE_FORMAT)
	private Date dateTo;
	@JsonProperty("hourFrom")
	private String hourFrom;
	@JsonProperty("hourTo")
	private String hourTo;
	@JsonProperty("ranking")
	private int ranking;

	public Item() {
	}

	public Item(int id, String name, String description, Double price, String currency, int ranking) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.currency = currency;
		this.ranking = ranking;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public List<WeekDay> getDays() {
		return days;
	}

	public void setDays(List<WeekDay> days) {
		this.days = days;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getHourFrom() {
		return hourFrom;
	}

	public void setHourFrom(String hourFrom) {
		this.hourFrom = hourFrom;
	}

	public String getHourTo() {
		return hourTo;
	}

	public void setHourTo(String hourTo) {
		this.hourTo = hourTo;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

}
