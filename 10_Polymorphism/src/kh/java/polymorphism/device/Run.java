package kh.java.polymorphism.device;

public class Run {
	public static void main(String[] args) {
		
		Device[] arr = new Device[10];
		arr[0] = new TV("삼성", "평면TV", 3_000_000, 10);
		arr[1] = new TV("LG", "울트라평면TV", 2_500_000, 20);
		arr[2] = new Laptop("LG", "그램17", 2_000_000, 512);
		arr[3] = new Laptop("apple", "맥북16", 3_000_000, 1024);

		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i] == null)
				break;
				
				if(arr[i] instanceof TV){ //tv를 검사하고 싶다 할때 instanceof사용
					((TV)arr[i]).channelUp();
				}
				
				else if (arr[i] instanceof Laptop){
					System.out.println(((Laptop)arr[i]).getCapacity());
				}
				System.out.println(arr[i].toString());
			}
				
		}
	}
	

