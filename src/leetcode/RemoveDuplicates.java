package leetcode;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		int[] A = {1, 1, 2};
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
}
