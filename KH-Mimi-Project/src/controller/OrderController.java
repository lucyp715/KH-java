package controller;

import io.OrderUpload;
import model.vo.Order;

public class OrderController {
	private OrderUpload ordertUpload = new OrderUpload();
	
	
	
	public void OrderUploading(Order order) {
		ordertUpload.upload(order);
	}
}
