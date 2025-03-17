package utils;

public class ReadSystemProperty {
	public static void main(String[] args) {
		System.out.println("Location " + System.getProperty("location", "xyz.cryptomaven.rest"));
		System.out.println("Tags " + System.getProperty("tags", "@Confidence"));
	}

}
