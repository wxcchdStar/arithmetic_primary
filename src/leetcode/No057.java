package leetcode;

import java.util.*;

/**
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class No057 {

    public static void main(String[] args) {
        int[][] result = insert(
                new int[][]{
//                        {1, 3},
//                        {6, 9}
                        {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
                },
                new int[]{
//                        2, 5
                        4, 8
                }
        );
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsList = new ArrayList<>();
        Collections.addAll(intervalsList, intervals);
        intervalsList.add(newInterval);

        intervalsList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int[] row : intervalsList) {
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
