package leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * @author chenhd
 */
public class No011 {

  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    System.out.println(maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  // 暴力解法
  private static int maxArea(int[] height) {
    if (height == null || height.length <= 1) {
      return 0;
    }
    int maxArea = 0;
    for (int i = 0; i < height.length; i++) {
      for (int j = 0; j < height.length; j++) {
        if (i != j) {
          int area = (i - j) * Math.min(height[i], height[j]);
          if (area > maxArea) {
            maxArea = area;
          }
        }
      }
    }
    return maxArea;
  }

  // 双指针解法：若移动较长边，那么就无法找到更大的面积
  private static int maxArea2(int[] height) {
    if (height == null || height.length <= 1) {
      return 0;
    }
    int maxArea = 0;
    int left = 0;
    int right = height.length - 1;

    while (right > left) {
      maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return maxArea;
  }
}
