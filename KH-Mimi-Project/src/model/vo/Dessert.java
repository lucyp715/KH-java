package model.vo;

import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Dessert implements Serializable{
	
	/**
	 * SerialVersionUID의 의의 : 객체를 파일에 입출력할 때 프로그램에 선언한 것과 파일에 있는 객체가 같은 것임을 자각하게 해주는 것
	 *  
	 */
	private static final long serialVersionUID = 2L;
	
	private String dessertName;
	private int price;
	private int kcal;
	private String shortSpecific;
	private JLabel image;
	private JButton button;
	
	
	public Dessert() {
		super();
	}


	public Dessert(String dessertName, int kcal, int price, String shortSpecific, JLabel image,JButton button) {
		super();
		this.dessertName = dessertName;
		this.price = price;
		this.kcal = kcal;
		this.shortSpecific = shortSpecific;
		this.image = image;
		this.button=button;
	}

	
	public String getDessertName() {
		return dessertName;
	}


	public void setDessertName(String dessertName) {
		this.dessertName = dessertName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getKcal() {
		return kcal;
	}


	public void setKcal(int kcal) {
		this.kcal = kcal;
	}


	public String getShortSpecific() {
		return shortSpecific;
	}


	public void setShortSpecific(String shortSpecific) {
		this.shortSpecific = shortSpecific;
	}


	public JLabel getImage() {
		return image;
	}


	public void setImage(JLabel image) {
		this.image = image;
	}


	public JButton getButton() {
		return button;
	}


	public void setButton(JButton button) {
		this.button = button;
	}


	@Override
	public String toString() {
		return "Dessert [dessertName=" + dessertName + ", price=" + price + ", kcal=" + kcal + ", shortSpecific="
				+ shortSpecific + ", image=" + image + ", button=" + button + "]";
	}


	
	
	
}
