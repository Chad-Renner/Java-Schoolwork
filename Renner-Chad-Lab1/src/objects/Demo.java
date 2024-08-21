package objects;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a month number or name. Names are case sensitive (EX: January, Febuary...): ");
		String selected_month_string = input.nextLine();
		try {
			int selected_month_integer = Integer.parseInt(selected_month_string);
			Month user_month = new Month(selected_month_integer);
			objectTests(user_month, input);
		} catch (NumberFormatException ex) {
			Month user_month = new Month(selected_month_string);
			objectTests(user_month, input);
		}
	}
	public static void objectTests(Month user_month, Scanner input) {		
	Month january = new Month("January");
	Month march = new Month("March");
	Month october = new Month("October");
	
	System.out.println("The month you chose is: " + user_month.getMonthName());
	System.out.println("Displaying the same thing using toString method: " + user_month.toString());
	System.out.println("The month you chose in numbers is: " + user_month.getMonthNumber());
	if (user_month.equals(january)) {
		System.out.println("The month you chose is equal to January");
	} else {
		System.out.println("The month you chose is not equal to January");
	}
	if (user_month.greaterThan(march))
	{
		System.out.println("The month you chose comes after March");
	} else {
		System.out.println("The month you chose comes before March");
	}
	if (user_month.lessThan(october)) {
		System.out.println("The month you chose comes before October");
	} else {
		System.out.println("The month you chose comes after October");
	}
	
	System.out.println("Type a new number to change your selected month:");
	String selected_month_string = input.nextLine();
	int selected_month_integer = Integer.parseInt(selected_month_string);
	user_month.setMonthNumber(selected_month_integer);
	System.out.println("Your new month is: " + user_month.getMonthName());
	System.exit(0);
	}
}
