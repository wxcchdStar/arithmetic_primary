package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class No056 {

    public static void main(String[] args) {
        int[][] result = merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        });
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int[] row : intervals) {
            if (list.isEmpty()) {
                list.add(row);
            } else {
                int[] last = list.remove(list.size() - 1);
                if (last[1] >= row[0]) {
                    // 区间重合
                    int[] newRow = new int[]{Math.min(last[0], row[0]), Math.max(last[1], row[1])};
                    list.add(newRow);
                } else {
                    list.add(last);
                    list.add(row);
                }
            }
        }

        int[][] newArr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            newArr[i] = list.get(i);
        }
        return newArr;
    }
}
