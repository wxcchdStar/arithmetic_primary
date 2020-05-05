package leetcode;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class No059 {

    public static void main(String[] args) {
        Utils.printArray(generateMatrix2(5));
    }

    public static int[][] generateMatrix2(int n) {
        int[][] result = new int[n][n];
        // 数
        int max = n * n;
        int num = 1;
        // 循环
        int circle = 0;
        // 坐标
        int i = 0, j = 0;
        // 每层循环的起点
        int[] source = {0, 0};
        // 方向，碰到边界、起点时转换
        int wayIndex = 0;
        int[][] way = {
                {0, 1}, //上
                {1, 0}, //右
                {0, -1}, //下
                {-1, 0}, //左
        };

        while (num <= max) {
            result[i][j] = num;
            num++;

            int tempI = i + way[wayIndex][0];
            int tempJ = j + way[wayIndex][1];

            if (tempI < circle || tempI >= n - circle || tempJ < circle || tempJ >= n - circle) {
                // 边界
                if (wayIndex + 1 >= way.length) {
                    circle++;
                }
                wayIndex = (wayIndex + 1) % way.length;

                i += way[wayIndex][0];
                j += way[wayIndex][1];
            } else if (source[0] == tempI && source[1] == tempJ) {
                // 起点
                if (wayIndex + 1 >= way.length) {
                    circle++;
                }
                wayIndex = (wayIndex + 1) % way.length;

                i += way[wayIndex][0];
                j += way[wayIndex][1];

                source = new int[]{i, j};
            } else {
                i += way[wayIndex][0];
                j += way[wayIndex][1];
            }

        }

        return result;
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int max = n * n;
        int num = 0;
        for (int i = 0; i < (n + 1) / 2; i++) {
            // 上
            int top;
            for (top = i; top < n - i; top++) {
                result[i][top] = ++num;
            }
            if (num >= max) {
                break;
            }
            // 右
            for (int right = i + 1; right < n - i - 1; right++) {
                result[right][n - i - 1] = ++num;
            }
            if (num >= max) {
                break;
            }
            // 下
            for (int bottom = n - i - 1; bottom >= i; bottom--) {
                result[n - i - 1][bottom] = ++num;
            }
            if (num >= max) {
                break;
            }
            // 左
            for (int left = n - i - 2; left > i; left--) {
                result[left][i] = ++num;
            }
            if (num >= max) {
                break;
            }
        }

        return result;
    }
}
