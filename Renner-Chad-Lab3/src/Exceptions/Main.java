package Exceptions;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws EmptyNameException, InvalidIdentificationNumberException, InvalidPayRateException, InvalidHoursWorkedException {
		final double maxHourlyPayRate = 84;
		final double maxHoursWorked = 25;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Input employee name:");
		String name = input.nextLine();
		if (name.isEmpty()) {
			input.close();
			throw new EmptyNameException("Name must not be an empty string");
		}
		System.out.println("Input employee ID:");
		int identificationNumber = input.nextInt();
		if (identificationNumber <= 0) {
			input.close();
			throw new InvalidIdentificationNumberException("ID must be greater than 0.");
		}
		System.out.println("Input employee hourly pay rate:");
		double hourlyPayRate = input.nextDouble();
		if (hourlyPayRate < 0 || hourlyPayRate > maxHourlyPayRate) {
			input.close();
			throw new InvalidPayRateException("Pay rate cannot be negative or greater than 25");
		}
		System.out.println("Input employee hours worked:");
		double hoursWorked = input.nextDouble();
		if (hoursWorked < 0 || hoursWorked > maxHoursWorked) {
			input.close();
			throw new InvalidHoursWorkedException("You cannot work less than zero hours or greater than 84 hours.");
		}
		var employee = new Payroll(name, identificationNumber, hourlyPayRate, hoursWorked);
		System.out.println("Employee gross pay is: " + employee.getGrossPay());
		
		input.close();
		System.exit(0);
	}

}
