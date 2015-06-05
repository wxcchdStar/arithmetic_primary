package jisuanke;

import java.util.Scanner;

public class LastWorldLength {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] array = line.split(" ");
		if (array.length == 0) {
			System.out.println(array[0].length());
		} else {
			System.out.println(array[array.length - 1].length());
		}
		scanner.close();
	}
}
