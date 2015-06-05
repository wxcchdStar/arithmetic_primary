package jisuanke;

import java.util.Scanner;

public class StrangeCountry {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line1 = scanner.nextLine();
		String line2 = scanner.nextLine();
		scanner.close();
		
		long num1 = Long.parseLong(line1, 2);
		long num2 = Long.parseLong(line2, 2);	
		String result = Long.toBinaryString(num1 ^ num2 ^ Long.MAX_VALUE);
		System.out.println(result.substring(result.length() - line1.length(), result.length()));
	}
}
