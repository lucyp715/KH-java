package school;

public class StudentTest {

	public static void main(String[] args) {
		
		double sumAge = 0;
		double sumHight = 0;
		double sumWigth = 0;
		
		Student [] studentArray = new Student[3];

		studentArray[0] = new Student("홍길동", 15, 171, 81);	
		studentArray[1] = new Student("한사람", 13, 183, 72);
		studentArray[2] = new Student("임걱정", 16, 175, 65);
		
		System.out.println("이름 \t 나이\t신장\t몸무게");
		for(int i = 0; i < studentArray.length; i++) {
			System.out.printf("%s\t%d\t%d\t%d%n",
					studentArray[i].getName(), studentArray[i].getAge(),
					studentArray[i].getHeight(), studentArray[i].getWeight());
			
			sumAge += studentArray[i].getAge();
			sumHight += studentArray[i].getHeight();
			sumWigth += studentArray[i].getWeight();
		}
		System.out.println();
		System.out.println("나이의 평균 : " + Math.round(sumAge/3*100)/100.0);
		System.out.println("신장의 평균 : " + (String.format("%.2f", sumHight/3)));
		System.out.println("몸무게의 평균 : " + (String.format("%.2f", sumWigth/3)));
	}

}
