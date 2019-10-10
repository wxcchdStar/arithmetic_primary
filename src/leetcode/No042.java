package leetcode;

import java.util.Arrays;

/**
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No042 {

  public static void main(String[] args) {
    // 核心就是左右两边高度的较小值减去当前高度
    int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap(arr));
    System.out.println(trap2(arr));
    System.out.println(trap3(arr));
  }

  private static int trap(int[] height) {
    int result = 0;
    for (int i = 1; i < height.length - 1; i++) {
      int maxLeft = 0;
      for (int l = i; l >= 0; l--) {
        maxLeft = Math.max(maxLeft, height[l]);
      }
      int maxRight = 0;
      for (int r = i; r < height.length; r++) {
        maxRight = Math.max(maxRight, height[r]);
      }
      System.out.println(i + "=" + height[i] + ",\t" + maxLeft + ", " + maxRight);
      result += Math.min(maxLeft, maxRight) - height[i];
    }
    return result;
  }

  private static int trap2(int[] height) {
    int[] maxLeftArr = new int[height.length];
    maxLeftArr[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      maxLeftArr[i] = Math.max(maxLeftArr[i - 1], height[i]);
    }

    int[] maxRightArr = new int[height.length];
    maxRightArr[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      maxRightArr[i] = Math.max(maxRightArr[i + 1], height[i]);
    }

    System.out.println(Arrays.toString(maxLeftArr));
    System.out.println(Arrays.toString(maxRightArr));

    int result = 0;
    for (int i = 0; i < height.length - 1; i++) {
      result += Math.min(maxLeftArr[i], maxRightArr[i]) - height[i];
    }
    return result;
  }

  private static int trap3(int[] height) {
    int result = 0, left = 0, right = height.length - 1;
    int maxLeft = 0, maxRight = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= maxLeft) {
          maxLeft = height[left];
        } else {
          result += maxLeft - height[left];
        }
        left++;
      } else {
        if (height[right] >= maxRight) {
          maxRight = height[right];
        } else {
          result += maxRight - height[right];
        }
        right--;
      }
    }
    return result;
  }

}
