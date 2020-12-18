package controller;

import io.DessertUpload;
import model.vo.Dessert;

public class DessertController {
	private DessertUpload dessertUpload = new DessertUpload();
	
	
	
	public void dessertUploading(Dessert dessert) {
		dessertUpload.upload(dessert);
	}
	
}
