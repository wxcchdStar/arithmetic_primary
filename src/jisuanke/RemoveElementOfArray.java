package jisuanke;

import java.util.Scanner;

public class RemoveElementOfArray {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] array = scanner.nextLine().split(" ");
		int[] A = convertToIntArray(array);
		int elem = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		System.out.println(removeElement(A, n, elem));
	}
	
	public static int removeElement(int[] A, int n, int elem) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				n--;
			}
		}
		return n;
	}
	
	public static int[] convertToIntArray(String[] numbers) {
		int[] result = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			result[i] = Integer.parseInt(numbers[i]);
		}
		return result;
	}
}
