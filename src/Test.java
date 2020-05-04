import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.print(random.nextInt(10) + "-");
        }
        System.out.println();
        for (int i = 0; i < 100; i++) {
            System.out.print(new Random().nextInt(10) + "-");
        }
    }
}
