package OOP;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int customer_number = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("___________________\nCustomer class demo\n___________________\nEnter your name:");
		String customer_name = input.nextLine();
		System.out.println("Enter your address:");
		String customer_address = input.nextLine();
		System.out.println("Enter your phone number:");
		String customer_phone = input.nextLine();
		System.out.println("Type \"Y\" if you wish to be added to the mailing list \"N\" otherwise:");
		Boolean customer_mail = (input.nextLine().equals("Y")) ? true : false;
		var customer_object = new Customer(customer_name, 
										   customer_address, 
										   customer_phone, 
										   customer_number, 
										   customer_mail);
		System.out.println("Customer name: " + customer_object.getName() + "\n"
						   + "Customer address: " + customer_object.getAddress() + "\n"
						   + "Customer phone number: " + customer_object.getTelephoneNumber() + "\n"
						   + "Customer mailing list status: " + customer_object.getMailingListStatus() + "\n"
						   + "Customer number (should be 0): " + customer_object.getCustomerNumber() + "\n"
						   + "___________________\nPurchase Method test\n____________________");
		var preferred_customer_object = new PreferredCustomer(customer_phone, customer_phone, customer_phone, customer_number, customer_mail);
		String sentinal = "Y";
		while (sentinal.equals("Y")) {
			System.out.println("Enter amount to purchase: ");
			double purchase_amount = input.nextDouble();
			preferred_customer_object.purchase(purchase_amount);
			System.out.println("Amount purchased: $" + String.format("%.2f",preferred_customer_object.getAmountPurchased()) + "\n"
							   + "Discount level: " + preferred_customer_object.getDiscountLevel() + "\n"
							   + "Type \"Y\" to make another purchase or \"N\" to stop, discount (if available) will be added: ");
			sentinal = input.next();
		}
		System.out.println("Exiting program");
		input.close();
		System.exit(0);
	}
}
