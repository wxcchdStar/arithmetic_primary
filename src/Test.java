import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

public class Test {

  public static void main(String[] args) throws UnsupportedEncodingException {
    int[] array = new int[10];
    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }
    int[] sz = new int[array.length];
    for (int i = 0; i < sz.length; i++) {
      sz[i] = 1;
    }
    int result = array.length;

    result = quickUnion(array, 4, 3, result, sz);
    System.out.println(Arrays.toString(array));

    result = quickUnion(array, 3, 8, result, sz);
    System.out.println(Arrays.toString(array));

    result = quickUnion(array, 4, 9, result, sz);
    System.out.println(Arrays.toString(array));
  }

  private static int quickUnion(int[] id, int p, int q, int result, int[] sz) {
    int rootP = find(id, p);
    int rootQ = find(id, q);
    if (rootP == rootQ) return result;
    id[rootP] = rootQ;
    return result - 1;
  }

  private static int find(int[] id, int p) {
    int root = p;
    while (root != id[root]) {
      root = id[root];
    }
    while (p != root) {
      int newp = id[p];
      id[p] = root;
      p = newp;
    }
    return root;
  }
}

