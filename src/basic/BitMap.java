package basic;

/**
 * @author chenhd
 */
public class BitMap {
  private static byte[] bits = new byte[2];

  public static void main(String[] args) {
    int num = 14;
    System.out.println(Integer.toBinaryString(num));

    System.out.println(String.format("%8s", Integer.toBinaryString(bits[0])).replace(' ', '0'));
    System.out.println(String.format("%8s", Integer.toBinaryString(bits[1])).replace(' ', '0'));

    add(num);
    System.out.println(String.format("%8s", Integer.toBinaryString(bits[0])).replace(' ', '0'));
    System.out.println(String.format("%8s", Integer.toBinaryString(bits[1])).replace(' ', '0'));

    System.out.println(contain(num));

    clear(num);
    System.out.println(String.format("%8s", Integer.toBinaryString(bits[0])).replace(' ', '0'));
    System.out.println(String.format("%8s", Integer.toBinaryString(bits[1])).replace(' ', '0'));

    System.out.println(contain(num));
  }

  private static void add(int num) {
    // num/8得到byte[]的index
    int arrayIndex = num >> 3;
    // num%8得到在byte[index]的位置
    int position = num & 0x07;
    //将1左移position后，那个位置自然就是1，然后和以前的数据做|，这样，那个位置就替换成1了。
    bits[arrayIndex] |= 1 << position;
  }

  private static void clear(int num) {
    // num/8得到byte[]的index
    int arrayIndex = num >> 3;
    // num%8得到在byte[index]的位置
    int position = num & 0x07;
    //将1左移position后，那个位置自然就是1，然后对取反，再与当前值做&，即可清除当前的位置了.
    bits[arrayIndex] &= ~(1 << position);
  }

  private static boolean contain(int num) {
    // num/8得到byte[]的index
    int arrayIndex = num >> 3;
    // num%8得到在byte[index]的位置
    int position = num & 0x07;
    //将1左移position后，那个位置自然就是1，然后和以前的数据做&，判断是否为0即可
    return (bits[arrayIndex] & (1 << position)) != 0;
  }

}
