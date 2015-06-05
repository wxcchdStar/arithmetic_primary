package jisuanke;

import java.util.Scanner;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] array = scanner.nextLine().split(" ");
		int[] A = convertToIntArray(array);
		System.out.println(removeDuplcates(A));
	}
	
	public static int removeDuplcates(int[] A) {
		if (A.length <= 1) return A.length;
		int len = A.length;
		for (int i = 1; i < A.length; i++) {
			if (A[i-1] == A[i]) {
				len--;
			}
		}
		return len;
	}
	
	public static int[] convertToIntArray(String[] numbers) {
		int[] result = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			result[i] = Integer.parseInt(numbers[i]);
		}
		return result;
	}
}
