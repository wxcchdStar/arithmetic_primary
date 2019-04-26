package somewhere;

/**
 * 找出出现次数超过数组一半长度的数
 */
public class FindNumberWhichHalfOfArrayLength {

  public static void main(String[] args) {
    System.out.println(test(new int[]{1, 2, 2, 2, 2, 2, 4, 4, 4, 3, 2}));
  }

  private static int test(int[] array) {
    if (array.length <= 0) {
      return 0;
    }
    int result = array[0];
    int times = 1;
    //若当前次数为0，将result更更新为当前数字。若当前数字与result相同，次数+1;若不不同则-1。 //由于⽬目标数字出现次数⽐比其他数字加起来还多，因此最后result中存的数字为怀疑的⽬目标数字
    for (int i = 0; i < array.length; i++) {
      if (times == 0) {
        result = array[i];
        times = 1;
      } else if (array[i] == result) {
        times++;
      } else {
        times--;
      }
    }
    System.out.println(times + ", " + result);
    //计算result中怀疑的⽬目标数字出现次数，进⾏行行最终确定 int time = 0;
    for (int i = 0; i < array.length; ++i) {
      if (array[i] == result) {
        times++;
      }
    }
    if (times * 2 < array.length) {
      return 0;
    } else {
      return result;
    }
  }
}