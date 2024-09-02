package app.mapl.util.methods.comparing;

public class CompareThing implements Comparable<CompareThing> {
	private String brand;
	private int ram;
	private int price;
	

	@Override
	public String toString() {
		return "CompareThing [brand=" + brand + ", ram=" + ram + ", price=" + price +    "]";
	} 

	@Override
	public int compareTo(CompareThing comp) {

		if (this.getRam() > comp.getRam())
			return 1;  // 1 -> change it
		else
			return -1; // -1 -> leave it alone
	} 
public CompareThing(String brand, int ram, int price) {
		super();
		this.brand = brand;
		this.ram = ram;
		this.price = price;
	}
  
public String getBrand() {
	return brand;
}

 
public void setBrand(String brand) {
	this.brand = brand;
}
 
public int getRam() {
	return ram;
}
 
public void setRam(int ram) {
	this.ram = ram;
}
 
public int getPrice() {
	return price;
}
 
public void setPrice(int price) {
	this.price = price;
}


}
