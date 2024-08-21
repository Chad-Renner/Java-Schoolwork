package Exceptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Payroll implements Serializable{
	private String name;
	private int identificationNumber;
	private double hourlyPayRate;
	private double hoursWorked;
	private String fileName;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public int getIdentificationNumber() {
		return identificationNumber;
	}
	public void setHourlyPayRate(double hourlyPayRate) {
		this.hourlyPayRate = hourlyPayRate;
	}
	public double getHourlyPayRate() {
		return hourlyPayRate;
	}
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public double getHoursWorked() {
		return hoursWorked;
	}
	public double getGrossPay() {
		return hourlyPayRate * hoursWorked;
	}
	public void serializeObject(String fileName) throws IOException {
		var fileOut = new FileOutputStream("Payroll/" + fileName + ".ser");
		var objectOutput = new ObjectOutputStream(fileOut);
		objectOutput.defaultWriteObject();
		objectOutput.close();
		fileOut.close();
		this.fileName = fileName;
	}
	public Payroll deserializeObject() throws IOException, ClassNotFoundException {
		var fileIn = new FileInputStream("Payroll/" + fileName + ".ser");
		var objectInput = new ObjectInputStream(fileIn);
		var returnObject = (Payroll)objectInput.readObject();
		objectInput.close();
		fileIn.close();
		return returnObject;
	}
	public Payroll(String name, int identificationNumber, double hourlyPayRate, double hoursWorked) {
		setName(name);
		setIdentificationNumber(identificationNumber);
		setHourlyPayRate(hourlyPayRate);
		setHoursWorked(hoursWorked);
	}
}
