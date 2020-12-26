package net.kh.member.run;

import java.util.Scanner;

import net.kh.member.momber.model.Member;

public class Run {

	public static void main(String[] args) {
		Member m = new Member();
		
		m.setMemberName("홍길");
		m.setMemberId("aaa111");
		m.setMemberPwd("1234");
		m.setPhone("01012341234");
		m.setEmail("aaa@gmail.com");
		m.setGender('여');
		m.setAge(20);
		
		
		System.out.printf("%s %s %s %s %s %s %s ",m.getMemberName(),
				m.getAge(),m.getGender(),m.getPhone(),m.getEmail(),
				m.getMemberId(),m.getMemberPwd());
				

		
//		//사용자 입력값으로 member객체 대입하기
//		Scanner sc = new Scanner(System.in);
//		
//		Member m = new Member();
//		System.out.print("이름 : ");
//		String memberName = sc.next();
//		m.setMemberName(memberName);
//		
//		System.out.print("아이디 : ");
//		String memberId = sc.next();
//		m.setMemberId(memberId);
//		
//		System.out.print("비밀번호 : ");
//		m.setMemberPwd(sc.next());
//		System.out.print("전화번호 : ");
//		m.setPhone(sc.next());
//		System.out.print("이메일 : ");
//		m.setEmail(sc.next());
//		System.out.print("성별(남/여) : ");
//		m.setGender(sc.next().charAt(0));
//		System.out.print("나이 : ");
//		m.setAge(sc.nextInt());
//		
//		
//		System.out.println(m.getMemberName());
//		System.out.println(m.getMemberId());
//		System.out.println(m.getMemberPwd());
//		System.out.println(m.getPhone());
//		System.out.println(m.getEmail());
//		System.out.println(m.getGender());
//		System.out.println(m.getAge());
	}

}
