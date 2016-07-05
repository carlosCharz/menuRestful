package com.wedevol.bean;

/*
 * Enum of week days
 */

public enum WeekDays {
	MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"), THURSDAY("Thrusday"), FRIDAY("Friday"), SATURDAY(
			"Saturday"), SUNDAY("Sunday");

	private final String day;

	WeekDays(String day) {
		this.day = day;
	}

	public String getDay(){
		return this.day;
	}
}
