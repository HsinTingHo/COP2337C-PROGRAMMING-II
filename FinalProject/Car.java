package finalProject;

public class Car {
	private String model;
	private Integer price;
	
	public Car(String model, Integer price) {
		this.model = model;
		this.price = price;
	}
	
	//mutators
	public String getModel() {
		return this.model;
	}
	public Integer getPrice() {
		return this.price;
	}
	//available packages
}
