package compony;

public class Test02 {

	public static void main(String[] args) {
	
		double num = Double.parseDouble(args[0]);
		
		Compony c = new Compony(num);
		
		
		System.out.println("연 기본급 합 : " + c.getIncome() + " 세후 : " + c.getAfterTaxIncome());
		System.out.println("연 보너스 합 : " + c.getBonus()  + " 세후 : " + c.getAfterTaxBonus());
		System.out.printf("연 지급액 합 : %.1f", c.getAfterTaxIncome() + c.getAfterTaxBonus());
	}

}