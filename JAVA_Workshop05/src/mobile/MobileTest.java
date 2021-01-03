package mobile;

public class MobileTest {

	public static void main(String[] args) {
		MobileTest mt = new MobileTest();
		// 각각의 Mobile 객체 생성
		Mobile Ltab = new Ltab("Ltab",500,"AP-01");
		Mobile Otab = new Otab("Otab",1000,"AND-20");
		
		// 생성된 객체의 정보 출력
		System.out.printf("  Mobile\tBattery\t\tOS%n");
		System.out.println("----------------------------------------"); 
		System.out.printf("   %-15s%-12d%s%n", Ltab.getMobileName(), Ltab.getBatterySize(), Ltab.getOsType());
		System.out.printf("   %-15s%-12d%s%n", Otab.getMobileName(), Otab.getBatterySize(), Otab.getOsType());
		
		// 각각의 Mobile 객체에 10분씩 충전
		Ltab.charge(10);
		Otab.charge(10);
		System.out.println("\n10분충전");
		// 10분 충전 후 객체 정보 출력
		System.out.printf("  Mobile\tBattery\t\tOS%n");
		System.out.println("----------------------------------------"); 
		System.out.printf("   %-15s%-12d%s%n", Ltab.getMobileName(), Ltab.getBatterySize(), Ltab.getOsType());
		System.out.printf("   %-15s%-12d%s%n", Otab.getMobileName(), Otab.getBatterySize(), Otab.getOsType());
		
		// 각각의 Mobile 객체에 5분씩 통화
		Ltab.opertate(5);
		Otab.opertate(5);
		System.out.println("\n5분통화");
		// 5분 통화 후 객체 정보 출력
		System.out.printf("  Mobile\tBattery\t\tOS%n");
		System.out.println("----------------------------------------"); 
		System.out.printf("   %-15s%-12d%s%n", Ltab.getMobileName(), Ltab.getBatterySize(), Ltab.getOsType());
		System.out.printf("   %-15s%-12d%s%n", Otab.getMobileName(), Otab.getBatterySize(), Otab.getOsType());
		
		
	
		
				
	}

}
