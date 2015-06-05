package jisuanke;

import java.util.Scanner;

public class ABC {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String in = scanner.nextLine();
		if (in != null && !in.equals("")) {
			String[] numbers = in.split(" ");
			int a = Integer.parseInt(numbers[0]);
			int b = Integer.parseInt(numbers[1]);
			int c = Integer.parseInt(numbers[2]);
			System.out.println(a + b + c);
		}
		scanner.close();
	}
}
