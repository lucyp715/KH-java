package kh.java.byte_object;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ObjectIOTest {

	public static void main(String[] args) {
		ObjectIOTest o = new ObjectIOTest();
		o.test1();
		o.test2();
	}

	/**
	 * 직렬화된 User데이터를 파일로 부터 읽어서 JVM에 가져오기
	 * try with resource
	 * jdk1.7 반납코드 생락할수 있게 해줌
	 * 
	 * transient는 Serialize하는 과정에 제외하고 싶은 경우 선언하는 키워드입니다.
   		쓰기 작업을 할 때 일어납니다.
   		패스워드와 같은 보안정보가 직렬화(Serialize) 과정에서 제외하고 싶은 경우에 적용합니다.
   		다양한 이유로 데이터를 전송을 하고 싶지 않을 때 선언할 수 있습니다.
	 */
	private void test2() {
		//fianlly 절 필요없음
		File f = new File("object/users.ser");
		try(ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream(f));){
//		User u1 =(User)ois.readObject();
//		User u2 =(User)ois.readObject();
//		User u3 =(User)ois.readObject();

//		System.out.println(u1);				
//		System.out.println(u2);				
//		System.out.println(u3);		
	
			
			//User 객체의 개수를 모르는 경우
//		while(true) {
//			User u = (User)ois.readObject();
//			System.out.println(u);
//		}
			
			//2. User[]객체 읽어오기
			User[] userArr = (User[])ois.readObject();
			for(int i = 0; i < userArr.length; i++) {
				System.out.println(userArr[i]);
			}
		
	}catch (EOFException e) {
			System.out.println("모든정보를 읽었습니다");
	} catch(IOException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	}

	/**
	 * User 객체를 파일에 기록
	 */
	private void test1() {
		User u1 = new User("hogged", "1234", "홍길동", new Date());
		User u2 = new User("sinsa", "1234", "신사임당", new Date());
		User u3 = new User("sejong", "1234", "세종대앙", new Date());
		//메모리상 안에 User객체가 생성된것->하지만 쓰면 바로 사라지는것이라서
		//파일에 저장시켜두면 User정보 안날가고 남아있음. 염속성 data.
		
		User[] userArr = new User [10];
		userArr[0] = u1;
		userArr[1] = u2;
		userArr[2] = u3;
		
		String fileName = "object/users.ser";
		//확장자는 어떤 응용프로그램으로 돌릴까 하는거기때문에 상관없다
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			//1. User객체를 여러개 출력
//			oos.writeObject(u1);
//			oos.writeObject(u2);
//			oos.writeObject(u3);
			
			//2. User[]객체 하나 출력
			oos.writeObject(userArr);
			//메모리상에 존재하는 User객체를 구현하기 위해서는  Serializable했어여한다
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("객체 출력 완료!");
	
				
		
		
	}

}
