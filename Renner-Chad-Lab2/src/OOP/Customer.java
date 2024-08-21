package OOP;

public class Customer extends Person{
	private int customer_number;
	private boolean mailing_list_status;
	
	public int getCustomerNumber() {
		return customer_number;
	}
	public boolean getMailingListStatus() {
		return mailing_list_status;
	}
	public void setCustomerNumber(int customer_number) {
		this.customer_number = customer_number;
	}
	public void setMailingListStatus(boolean mailing_list_status) {
		this.mailing_list_status = mailing_list_status;
	}
	public Customer(String name, String address, String telephone_number, int customer_number, boolean mailing_list_status) {
		super(name, address, telephone_number);
		setCustomerNumber(customer_number);
		setMailingListStatus(mailing_list_status);
	}
}
