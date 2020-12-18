package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import model.vo.Order;
import view.mainFrame.MainFrame;

public class ReadingOrder {
	File f = new File("orderGathering/order.txt");
	ObjectInputStream ois = null;
	private List<Order> allOrderList;
	private List<Order> personalOrderList = new ArrayList<>();

	public ReadingOrder() {

	}

	public List<Order> readingHoleOrder(String name) {
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			allOrderList = (List<Order>) ois.readObject();

			if (name.equals("kang")) {
				personalOrderList=allOrderList;
			} else {
				personalOrderList.clear();
				for (Order order : allOrderList) {
					if (order.getUserId().equals(MainFrame.user.getUserId())) {
						personalOrderList.add(order);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return personalOrderList;
	}
	
}
