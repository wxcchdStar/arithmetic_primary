package jisuanke;

import java.util.Scanner;

public class SearchInsertIndex {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] array = scanner.nextLine().split(" ");
		int[] A = convertToIntArray(array);
		int elem = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		System.out.println(searchInsert(A, n, elem));
	}
	
	public static int searchInsert(int A[], int n, int target) {
		if (A[0] > target) {
			return 0;
		}
		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] == target) {
				return i - 1;
			} else if (A[i] == target) {
				return i;
			} else if (A[i - 1] < target && A[i] > target) {
				return i;
			}
		}
		return A.length;
	}
	
	public static int[] convertToIntArray(String[] numbers) {
		int[] result = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			result[i] = Integer.parseInt(numbers[i]);
		}
		return result;
	}
}
