package jisuanke;

import java.util.Scanner;

public class Divisible {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String in = scanner.nextLine();
		if (in != null && !in.equals("")) {
			String[] numbers = in.split(" ");
			int m = Integer.parseInt(numbers[0]);
			int n = Integer.parseInt(numbers[1]);
			if (m % n == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		scanner.close();
	}
}
