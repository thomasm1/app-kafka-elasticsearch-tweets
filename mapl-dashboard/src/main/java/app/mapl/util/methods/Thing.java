package app.mapl.util.methods;

public class Thing { 
	private int x;
	private String str;
	 
	public Thing(String str, int x){
		this.str = str;
		this.x = x;
	};
	public int getPrice() {
		return x;
	}
	public String getName() {
		return str;
	}
	
	@Override
	public String toString() {
		StringBuilder thing = new StringBuilder();
		thing.append("Car{name=").append(str).append("...and Price=").append(x);
		return thing.toString();
	
	}
}
