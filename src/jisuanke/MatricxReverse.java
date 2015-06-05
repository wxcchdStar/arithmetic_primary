package jisuanke;

import java.util.Scanner;

public class MatricxReverse {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] matricesInfos = scanner.nextLine().split(" ");
		int m = Integer.parseInt(matricesInfos[0]);
		int n = Integer.parseInt(matricesInfos[1]);
		int t = Integer.parseInt(matricesInfos[2].trim());
		int[][] matrices = new int[m][n];
		int readLine = 0;
		while (readLine < m) {
			String line = scanner.nextLine();
			String[] numbers = line.split(" ");
			for (int i = 0; i < n; i++) {
				matrices[readLine][i] = Integer.parseInt(numbers[i].trim());
			}
			readLine++;
		}
		scanner.close();
		
		if (t == 1) { // 上下翻转
			for	(int i = 0; i < n; i++) {
				int start = 0;
				int end = m - 1;
				while (start < end) {
					matrices[start][i] ^= matrices[end][i];
					matrices[end][i] ^= matrices[start][i];
					matrices[start][i] ^= matrices[end][i];
					start++;
					end--;
				}
			}
		} else { // 左右翻转
			for	(int i = 0; i < m; i++) {
				int start = 0;
				int end = n - 1;
				while (start < end) {
					matrices[i][start] ^= matrices[i][end];
					matrices[i][end] ^= matrices[i][start];
					matrices[i][start] ^= matrices[i][end];
					start++;
					end--;
				}
			}
		}
		
		// print matrices
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrices[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
