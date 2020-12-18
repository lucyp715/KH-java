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

import model.vo.Dessert;
import model.vo.User;

public class DessertUpload {
	File f = new File("Dessert/dessert.txt");
	ObjectOutputStream oos =null;
	ObjectInputStream ois =null;
	public File getF() {
		return f;
	}
	public void setF(File f) {
		this.f = f;
	}
	public void upload(Dessert dessert) {
		List<Dessert> dessertList;
		if(!(f.exists())) {
			try {
				oos = new ObjectOutputStream(new FileOutputStream(f));
				dessertList = new ArrayList<Dessert>();
				dessertList.add(dessert);
				oos.writeObject(dessertList);
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
				dessertList =(List<Dessert>)ois.readObject();
				dessertList.add(dessert);	
				oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(dessertList);
			
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
		}
	}
}
