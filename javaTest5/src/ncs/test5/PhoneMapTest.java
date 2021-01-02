package ncs.test5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PhoneMapTest {

	public static void main(String[] args) {
		Map<String, Phone> map = new HashMap<String, Phone>();
		Properties prop = new Properties();
		// Phone 객체를 3개 생성하여 맵에 모델을 key로 객체를 저장한다.
		map.put("galaxy S7", new Phone("galaxy S7",563500,"삼성",7));
		map.put("iphone 6s", new Phone("iphone 6s",840000,"애플",3));
		map.put("G5", new Phone("G5",563500,"LG",5));

		// 맵에 저장된 객체 정보를 연속 출력 한다.
		Set<String> keySet = map.keySet();

		for(String key : keySet) {
		}
		
		//– Map.EntrySet<String, Phone> 사용할 것
		Set<Map.Entry<String,Phone>> entrySet = map.entrySet();
		for(Entry<String, Phone> entry : entrySet) {
		String key = entry.getKey();
		Phone value = entry.getValue();
		System.out.println(value);
	}
		// 맵에 저장된 객체 정보를 Properties 를 사용해 “phone.xml” 파일에 기록 저장한다.
		//파일기록
		try{
		prop.storeToXML(new FileOutputStream("phone.xml"), "phone.xml");
			System.out.println("phone.xml 파일에 성공적으로 저장되었습니다.");
		}catch(IOException e) {
			e.printStackTrace();
	}

}
}
