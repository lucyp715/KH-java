package kh.java.byte_.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest {

	public static void main(String[] args) {
		FileIOTest f = new FileIOTest();
//				f.test1();
				f.test2();

	}
	/**
	 * 기본 스트림 + 보조스트림
	 */
	private void test2() {
		String fileName = "file/myfile.txt";
		String copy = "file/newCopy.txt";
		FileInputStream fis =null;
		BufferedInputStream bis = null; // 성능향상을 위해서
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(fileName));
			bos = new BufferedOutputStream(new FileOutputStream(copy));
			
			int data = 0;
			
			while((data = bis.read()) != -1) {
				bos.write(data);
			}
			
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * file -> JVM 파일입력
	 * JVM -> file 파일 출력
	 */
	private void test1() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String fileName ="C:\\Users\\soyeo\\Desktop\\study\\main.jpeg";
	//	String fileName = "file/myfile.txt";
		String copy = "file/main.jpeg";
		try {
			fis = new FileInputStream(fileName);
			fos = new FileOutputStream(copy);
			
			//(0~255)256가지  + 1(값없음 -1)
			int data = 0; //byte 사용불가, read의 기본형이 int
			
			while((data = fis.read()) != -1) { 
				System.out.print((char)data + " ");
				
				//파일을 출력하면서 콘솔도 출력하는것 상위폴더에서 새로고침(f5)
				fos.write(data);
				
			}
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace(); // 없어도 상관없다 - 어짜피 IOException에 포함
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//자원반납 -필수
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace(); // 컴파일 오류나서 try catch사용
			}
		}
		
	}

}
