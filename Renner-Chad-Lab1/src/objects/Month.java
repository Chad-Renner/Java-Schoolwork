package objects;

import java.util.Arrays;
import java.util.List;

public class Month {
	private static final int JANUARY = 1;
	private static final int MONTH_MAX = 12;
	private int monthNumber;
	private List<String> months = Arrays.asList(
		"January",
		"Febuary",
		"March",
		"April",
		"May",
		"June",
		"July",
		"August",
		"September",
		"October",
		"November",
		"December"
	);
	public Month() {
		monthNumber = JANUARY;
	}
	public Month(int selected_month) {
		if (selected_month < JANUARY || selected_month > MONTH_MAX) {
			monthNumber = JANUARY;
			System.out.println("Index out of range. Month initialized to January");
		} else {
			monthNumber = selected_month;
		}
	}
	public Month(String selected_month) {
		if (months.contains(selected_month)) {
			monthNumber = months.indexOf(selected_month);
			monthNumber++;
		} else {
			monthNumber = JANUARY;
			System.out.println("Inserted month not found. Initialized to January");
		}
	}
	public void setMonthNumber(int selected_month) {
		if (selected_month < JANUARY || selected_month > MONTH_MAX) {
			monthNumber = JANUARY;
			System.out.println("Index out of range. Month set to January");
		} else {
			monthNumber = selected_month;
		}
	}
	public int getMonthNumber() {
		return monthNumber;
	}
	public String getMonthName() {
		int month_index = monthNumber - 1;
		return months.get(month_index);
	}
	public String toString() {
		return this.getMonthName();
	}
	public boolean equals(Month selected_month) {
		Boolean result = (this.getMonthNumber() == selected_month.getMonthNumber()) ? true : false;
		return result;
	}
	public boolean greaterThan(Month selected_month) {
		Boolean result = (this.getMonthNumber() > selected_month.getMonthNumber()) ? true : false;
		return result;
	}
	public boolean lessThan(Month selected_month) {
		Boolean result = (this.getMonthNumber() < selected_month.getMonthNumber()) ? true : false;
		return result;
	}
}
