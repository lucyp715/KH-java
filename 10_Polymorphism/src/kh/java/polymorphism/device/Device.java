package kh.java.polymorphism.device;

public class Device {

	private String brand;
	private String deviceName;
	private int price;
	public Device() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	public Device(String brand, String deviceName, int price) {
		super();
		this.brand = brand;
		this.deviceName = deviceName;
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Device [brand=" + brand + ", deviceName=" + deviceName + ", price=" + price + "]";
	}
	
}
