package ncs.test4;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class NoticeTest {

	public static void main(String[] args) {
		Object[] obArray = new Object[3];
		Scanner sc = new Scanner(System.in);
		NoticeTest n = new NoticeTest();
		
		int no;
		String title;
		String writer;
		String content;
		Date[] drr= new Date[3];
		
		Calendar cal = Calendar.getInstance();
	//	cal.set(year, month-1, date);
		//키보드로 Notice 객체의 초기값을 입력받아, 생성자로 초기화한다. 
		//for 사용
		//no 는 인덱스 + 1
		//date 는 직접 값 지정 처리함
		for(int i = 0; i < obArray.length; i++){
			System.out.println("등록할 공지사항을 입력하시오.");
			System.out.print("제목 : ");
			title = sc.nextLine();
			System.out.print("작성자 : ");
			writer = sc.nextLine();
			System.out.print("내용 : ");
			content = sc.nextLine();
			no = i+1;
			obArray[i] = new Notice(no, title, drr[i], writer, content);
		}
		n.fileSave(obArray);
		
		ArrayList<Notice> nlist = new ArrayList<>();
		nlist = n.fileRead();
	}
		//fileSave() 메소드 실행
	public void fileSave(Object[] array) {
		ObjectOutputStream oos = null;
		
		try{
		oos = new ObjectOutputStream(new FileOutputStream("notice.dat"));
	
		}catch(IOException e){
		e.printStackTrace();
	}finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		 
		//fileRead() 메소드 실행
	public ArrayList<Notice> fileRead(){
		ArrayList<Notice> list = new ArrayList<Notice>();
		File f = new File("notice.dat");
		
		try(ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream(f));){
			
			//리턴된 리스트 정보 출력 처리 – for each 문 사용
			Object[] obArray = (Object[])ois.readObject();
		//	for(int i = 0; i < userArr.length; i++) {
		//		System.out.println(userArr[i]);
		//	}
			for(Object o : obArray) {
				System.out.println(o);
			}
		}catch(EOFException e) {
			System.out.println("모든 정보를 읽었습니다.");
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
}