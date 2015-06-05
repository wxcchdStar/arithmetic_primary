package jisuanke;

import java.util.Scanner;

public class PrimeNumber {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		boolean isPrime = true;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		scanner.close();
		
//		for (int i = 1; i <= 1000; i++ ) {
//			test(i);
//		}
	}
	
	public static void test(int n) {
		boolean isPrime = true;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println(n + " YES");
		} else {
			System.out.println(n + " NO");
		}
	}
}
