package net.kh.member.run;

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
				

	}

}
