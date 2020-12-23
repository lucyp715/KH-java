package io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.vo.User;


public class GeneratingAccount {
	File f = new File("userAccount/userAccount.txt");
	ObjectOutputStream oos =null;
	ObjectInputStream ois =null;
	public void generate(User user){
		try {
			
			ois = new ObjectInputStream(new FileInputStream(f));
			List<User> userList = (List<User>) ois.readObject();
			
			userList.add(user);
			
			oos = new ObjectOutputStream(new FileOutputStream(f));
			
			oos.writeObject(userList);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
}
	
	
	
