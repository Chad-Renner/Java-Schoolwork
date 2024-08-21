package OOP;

public class PreferredCustomer extends Customer {
	private double amount_purchased;
	private double discount_level;
	private static final double[] DISCOUNT_TARGETS = {500, 1000, 1500, 2000}; //finish
	private static final double[] DISCOUNTS = {0.05, 0.06, 0.07, 0.1};
	
	public double getAmountPurchased() {
		return amount_purchased;
	}
	public double getDiscountLevel() {
		return discount_level;
	}
	public void setAmountPurchased(double amount_purchased) {
		this.amount_purchased = amount_purchased;
	}
	public void setDiscountLevel(double discount_level) {
		this.discount_level = discount_level;
	}
	public void purchase(double amount) {
		if (amount < 0) {
			System.out.println("Purchase must not be negative.");
		} else {
			if (discount_level > 0) {
				amount -= (discount_level * amount);
			}
			for (int i = 0, m = DISCOUNTS.length; i < DISCOUNTS.length; i++) {
				m--;
				if ((amount + amount_purchased) >= DISCOUNT_TARGETS[m]) {
					discount_level = DISCOUNTS[m];
					break;
				} 
			}
			amount_purchased += amount;
		}
	}
	public PreferredCustomer(String name, String address, String telephone_number, int customer_number, boolean mailing_list_status) {
		super(name, address, telephone_number, customer_number, mailing_list_status);
		setAmountPurchased(0);
		setDiscountLevel(0);
	}
}