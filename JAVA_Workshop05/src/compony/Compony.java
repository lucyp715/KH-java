package compony;

public class Compony {
	
	private double salary;
	private double annualIncome; 
	private double afterTaxIncome; 
	private double bonus; 
	private double afterTaxBonus; // 세후
	public Compony() {
		super();
		
	}
		
	public Compony(double salary) {
		super();
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	public double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	
	public double getAfterTaxIncome() {
		return (salary *12) - (salary*12*0.1);
	}
	public void setAfterTaxIncome(double afterTaxIncom) {
		this.afterTaxIncome = afterTaxIncom;
	}
	
	
	public double getBonus() {
		return salary *0.2*4;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	
	public double getAfterTaxBonus() {
		return (salary *0.2*4) - (salary *0.2*4*0.055);
	}
	public void setAfterTaxBonus(double afterTaxBonus) {
		this.afterTaxBonus = afterTaxBonus;
	}

	public double getIncome() {
		return salary * 12;
	}
	
	
}
