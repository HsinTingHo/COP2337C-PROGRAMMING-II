
public class TestRetailItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RetailItem r1=new RetailItem("Jacket",12,59.95);
		RetailItem r2=new RetailItem("Designer Jeans",40,34.95);
		RetailItem r3=new RetailItem("Shirt",20,24.95);
		System.out.println("\tDescription\tUnits on Hand\tPrice");
		System.out.println("Item #1\t"+r1.getDescription()+"\t\t"+r1.getUnitsOnHand()+"\t"+r1.getPrice());
		System.out.println("Item #1\t"+r2);
		System.out.println("Item #1\t"+r3.getDescription()+"\t\t"+r3.getUnitsOnHand()+"\t"+r3.getPrice());
	}

}
