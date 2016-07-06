package com.wedevol.bean;

/*
 * Enum of week days
 */

public enum WeekDay {
	MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"), THURSDAY("Thrusday"), FRIDAY("Friday"), SATURDAY(
			"Saturday"), SUNDAY("Sunday");

	private final String day;

	WeekDay(String day) {
		this.day = day;
	}

	public String getDay(){
		return this.day;
	}
}
