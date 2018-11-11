package codefights;

// 从数组中去掉一个数, 使数组可以严格递增
public class AlmostIncreasingSequence {

  // 以断点分隔, 有左右两个数组, 去掉左数组中的最大值或右数组中最小值, 看看数组是否可递增的
  public static void main(String[] args) {
    System.out.println(almostIncreasingSequence(new int[]{
        1, 2, 3, 4, 3, 6, 5
    }));
    System.out.println(almostIncreasingSequence(new int[]{
        1, 2, 3, 4, 99, 5, 6, 7
    }));
  }

  private static boolean almostIncreasingSequence(int[] sequence) {
    if (sequence.length <= 1) return true;

    int firstPoint = Integer.MIN_VALUE;
    int secondPoint = Integer.MIN_VALUE;

    for (int i = 1; i < sequence.length; i++) {
      if (sequence[i - 1] >= sequence[i]) {
        if (firstPoint < 0) {
          firstPoint = i - 1;
        } else if (secondPoint < 0) {
          secondPoint = i - 1;
        } else {
          return false;
        }
      }
    }
    if (secondPoint == Integer.MIN_VALUE) {
      if (firstPoint > 0 && firstPoint < sequence.length - 1
          && sequence[firstPoint - 1] < sequence[firstPoint + 1]) {
        return true;
      } else if (firstPoint >= 0 && firstPoint < sequence.length - 2
          && sequence[firstPoint] < sequence[firstPoint + 2]) {
        return true;
      }
    }
    return false;
  }

}
