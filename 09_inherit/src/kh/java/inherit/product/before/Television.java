 package kh.java.inherit.product.before;

public class Television {
	
	private String brand;
	private String productName;
	private int price;
	
	private int size;
	
	public Television() {
		super(); //부모생성자 호출. 자동생성 호출. 딱한번 최상단에서 사용가능
		
	}

	public Television(String brand, String productName, int price, int size) {
		super();
		this.brand = brand;
		this.productName = productName;
		this.price = price;
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	public String getTelevisionInfo() {
		return brand + "," + productName + "," + price + "," +
				size;
	}

}
