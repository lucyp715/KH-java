package kh.java.array;

/**
 * 
 * 얇은 복사 shallow copy
 * - 배열의 주소값(call stack)을 복사
 *  
 * 깊은복사 deep copy
 * - 실제 배열(heap)을 복사
 */

// 배열 a , 배열 b
// 배열 a를 얕은 복사 한게 배열 b
// 얕은 복사 -> 주소값
// 배열은 힙에 만들어지는데, 이 힙에 만들어진 a의 공간을 b에서도 가리킨다.
// a를 변경하면 b도 변경이 된다. b를 변경해도 a도 변경된다.

// 깊은 복사 : 배열이 가지고 있는 값만 복사
// a를 변경해도 b에는 변경이 일어나지 않음. 반대도 동일.


public class ArrayCopyTest {

	public static void main(String[] args) {
		
		ArrayCopyTest a = new ArrayCopyTest();
//		a.test1();
		a.test2();
//		a.test3();
	}
	/**
	 * /**
	 *  깊은 복사2
	 * - clone
	 * - system.arrayCopy
	 * 
	 */
	
	public void test3() {
		
		byte[] arr1 = {1,2,3,4,5};
		byte[] arr2 = arr1.clone();
		
		System.out.println(arr1.hashCode());
		System.out.println(arr2.hashCode());
		
		printArr(arr1);
		printArr(arr2);
		
		byte[] arr3 = new byte[arr1.length];
		//void java.lang.System.arraycopy
		//Object src, int srcPos, Object dest, int destPos, int length)
//		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		System.arraycopy(arr1, 2, arr3, 1, 3);
		
		System.out.println(arr3.hashCode());
		printArr(arr3);
		
	}
	/**
	 * r깊은 복사1
	 * - 반복문을 통해 직접 요소값 복사
	 * 
	 */
	public void test2() {
		
		byte[] arr1 = {10, 20, 30};
		byte[] arr2 = new byte[arr1.length]; //매직넘버보다는 변수로 치환해서 사용이 훨씬좋음 
		
//		arr2[0] = arr1[0];
//		arr2[1] = arr1[1];
//		arr2[2] = arr1[2];
		
		for(int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
			
		}
		
		arr1[1] = 127;
		
		System.out.println(arr1.hashCode());
		System.out.println(arr2.hashCode());
		
		printArr(arr1);
		printArr(arr2);
	}
	/**
	 * 얕은 복사
	 * 
	 */
	public void test1() {
		
		byte[] arr1 = {1, 2, 3};
		byte[] arr2 = arr1;
		
		arr1[1] = 100;
		
		System.out.println(arr1);
		System.out.println(arr2);
		System.out.println(arr1.hashCode());
		System.out.println(arr2.hashCode());
		
		printArr(arr1);
		printArr(arr2);
	}
	
	
	public void printArr(byte[] arr) {
		for(int i =0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}
