package kh.java.inherit.product.after;

public class Computer extends Product{
	private String os;
	
	public Computer() {}
	
	public Computer(String brand, String productName, int price,
			String os) { 
		super(brand, productName, price);
		this.os = os;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	public String getComputerInfo() {
		return getBrand() + "," + getProductName() + "," + 
				getPrice() + "," + os;
	}
	@Override
	public String getProductInfo() {
		//부모클래스 Product의 getProductInfo 호출
		return super.getProductInfo() + "," + os;
	}
}
