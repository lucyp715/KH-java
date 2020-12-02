package kh.java.collection.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Properties
 * HashTable을 상속한 map의 예쩐 클래ㅡ
 * key,value 타입을 String, String으로 제한해서
 * 설정정보를 관리하는데 최적화
 *
 */
public class PropertiesTest {
 
	public static void main(String[] args) {
		PropertiesTest p = new PropertiesTest();
		p.test1();
		p.test2();
	}
	
	private void test2() {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("user.properties"));
			//load는 (파일인풋스트임파일) 스티림으로 열린 프로퍼티스 파일객체를 로드
			prop.loadFromXML(new FileInputStream("user.xml"));
			System.out.println(prop);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//개별접근
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String url = prop.getProperty("url");
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		System.out.println("url = " + url);
		
		//전체요소 열람
		//1.list
		prop.list(System.out);
		
		//2.Enumeration : keySet -> iterator
		Enumeration<?> names = prop.propertyNames();
		while(names.hasMoreElements()) {
			String name = (String)names.nextElement();
	//		System.out.println(name);
			String value = prop.getProperty(name);
			System.out.println(name + " = " + value);
		}
	}

	private void test1() {
		Properties prop = new Properties();
		prop.setProperty("username", "hongged");
		prop.setProperty("password", "1234");
		prop.setProperty("url", "http://iei.or.kr");
		
		System.out.println(prop);
		
		//파일기록
		try {
			prop.store(new FileWriter("user.properties"), "user.properties");
			//xml : 사용자 정의태그 파일(형식)
			prop.storeToXML(new FileOutputStream("user.xml"), "user.xml");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("prop 저장완료!");
	}

}
