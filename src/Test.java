public class Test {
	
	public static void main(String[] args) {
		System.out.println(String.format("%s took clay from %s.", "x", "y"));
        char a = 'a', b = 'a';
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a + ", " + b);
	}

}
