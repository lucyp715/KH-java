package kh.java.exception;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 
 * 0.리턴타입, 메소드명, 매개변수 선언부가 완전 동일할 것
 * 1.접근제한자는 부모메소드보다 넣게 설정할 수 있다  .
 * -default ->protected -?public
 * 2.부모메소드에서 던지는 예외는 오버라이딩시에 개수는 더 적게,
 *   혹은 자식클래스로 변화 가능
 *
 */
public class OverridingTest {

	public static void main(String[] args) {

	}

}

class Parent{
	public void overrideMe() throws SQLException, IOException{
		//예외를 가져가. SQLException 데이터접속예외의 최상의클래스
		//ctrl +t -> 대칭구조확인할떄 유용, 자식클래스를 알수있다.
		
	}
}

class Child extends Parent{
	
	@Override
	public void overrideMe() {}
//	public void overrideMe() thorws SQLException{}
//	public void overrideMe() thorws SQLSyntaxErrorException{}
//	public void overrideMe() thorws Exception{} 
	//부모타입변환은불가하다. 부모타입이 최상위라서 
	
}
