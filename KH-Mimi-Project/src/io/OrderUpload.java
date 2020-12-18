package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.vo.Order;
import model.vo.User;

public class OrderUpload {
	File f = new File("orderGathering/order.txt");
	ObjectOutputStream oos =null;
	ObjectInputStream ois =null;
	
	public File getF() {
		return f;
	}
	
	public void setF(File f) {
		this.f = f;
	}
	
	public void upload(Order dessert) {
		List<Order> orderList;
		if(!(f.exists())) {
			try {
				oos = new ObjectOutputStream(new FileOutputStream(f));
				orderList = new ArrayList<Order>();
				orderList.add(dessert);
				oos.writeObject(orderList);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}
		else {
			try {
				ois = new ObjectInputStream(new FileInputStream(f));
				orderList =(List<Order>)ois.readObject();
				orderList.add(dessert);	
				oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(orderList);
			
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				try {
					ois.close();
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}
	}
}
