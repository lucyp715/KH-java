package kh.java.char_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRWTest {

	public static void main(String[] args) {
		FileRWTest f = new FileRWTest();
		f.test1();

	}
	public void test1() {
		//파일객체 : 실체파일을  가리키고 있는 자바객체
		File f = new File("file/myfile.txt");
		File copy = new File("file/realNewCopy.txt");
		FileReader fr = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(new FileWriter(copy));
			//기본스트림만 사용한 경우
//			int data = 0;
//				while((data = fr.read()) != -1) {
//					System.out.print((char)data);
//				}
			
			String line = ""; // 라인다위로 처리할 수 있다.
			//파일의 내용 -> 자바객체
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null){
				System.out.println("> " + line);
				sb.append(line); // 개행문자없이 한줄에 전부출력
				sb.append("\n"); //이거까지 써주니 다시 각자의 줄로 출력
				
				//복붙
//				bw.write(line); // 개행안주면 한줄로나옴
//				bw.write("\n");
				
			}
			sb.append("추가적으로 작업한 내용 \n");
			System.out.println(sb);
			
			bw.write(sb.toString());
			
		} catch (IOException | RuntimeException e) { //멀티절
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

