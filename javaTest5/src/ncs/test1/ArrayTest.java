package ncs.test1;

public class ArrayTest {

	public static void main(String[] args) {
		ArrayTest at = new ArrayTest();
		int[] array = new int [6];
		 
		for(int i =0; i <array.length; i++) {
			array[i] = (int)(Math.random()*100+1);
		}
		System.out.println("할당된 배열의 크기 : " + array.length);
		System.out.print("array : ");
		at.print(array);
		System.out.println("\n가장 큰 값 : " + at.max(array));
		System.out.println("가장 작은 값 : " + at.min(array));
		System.out.println("짝수의 개수 : " + at.evenCount(array));
		System.out.println("홀수의 개수 : " + at.oddCount(array));
		System.out.println("합계 : " + at.sum(array));
		System.out.printf("평균 : %.2f", at.avg(array));
	}
	
	public int sum(int[]arr) {
		int sum =0;
		for(int i =0; i <arr.length; i++) {
			sum+= arr[i];
		}
		return sum;
	}
	
	public double avg(int[]arr) {
//		double avg = 0.0;
//	    for (int i = 0; i < arr.length; i++)
//	    	avg += arr[i];
		return sum(arr) / arr.length;
	}
	
	public int max(int[] arr) {
		int max = arr[0];
		
		for(int i=0; i < arr.length; i++) {
		    if(max < arr[i]) 
		    	max = arr[i];
		}
		return max;
	}
	
	public int min(int[] arr) {
		int min = arr[0];
		
		for(int i=0; i < arr.length; i++) {
		    if(min > arr[i]) 
		    	min = arr[i];
		}
		
		return min;
	}
	
	public int evenCount(int[] arr) {
		int evenCount = 0;
		
		for(int i=0; i < arr.length; i++) {
			
			if(arr[i] %2 == 0)
				evenCount ++;
		}
		return evenCount;
	}
	
	public int oddCount(int[] arr) {
		int oddCount = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] % 2 != 0 )
			
				oddCount++;
		}
		return oddCount;
	}
	
	public void print(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
		
			System.out.print(arr[i] + "  ");
		}
	}


} 
	


