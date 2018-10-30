
public class RetailItem {

	private String description;
	private int unitsOnHand;
	private double price;
	
	public RetailItem(String description,int unitsOnHand,double price) {
		this.description=description;
		this.unitsOnHand=unitsOnHand;
		this.price=price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getUnitsOnHand() {
		return unitsOnHand;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		String msg=description+"\t"+unitsOnHand+"\t"+price;
		return msg;
	}
	
}
