package OOP;

public class Person {
	private String name;
	private String address;
	private String telephone_number;
	
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getTelephoneNumber() {
		return telephone_number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTelephoneNumber(String telephone_number) {
		this.telephone_number = telephone_number;
	}
	public Person(String name, String address, String telephone_number) {
		setName(name);
		setAddress(address);
		setTelephoneNumber(telephone_number);
	}
}

