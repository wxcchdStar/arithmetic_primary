package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 * <p>
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No739 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new No739().dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
  }

  public int[] dailyTemperatures(int[] T) {
    int[] result = new int[T.length];
    for (int i = 0; i < T.length; i++) {
      result[i] = 0;
      for (int j = i + 1; j < T.length; j++) {
        if (T[j] > T[i]) {
          result[i] = j - i;
          break;
        }
      }
    }
    return result;
  }

  public int[] dailyTemperatures2(int[] T) {
    int[] result = new int[T.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = T.length - 1; i >= 0; i--) {
      // 把小于当前的数都取出来
      while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
        stack.pop();
      }
      result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
      stack.push(i);
    }
    return result;
  }
}
