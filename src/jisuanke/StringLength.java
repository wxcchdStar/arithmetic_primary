package jisuanke;

import java.util.Scanner;

public class StringLength {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(len_str(str));
		scanner.close();
	}
	
	public static int len_str(String str) {
		return str.length();
	}
}
