package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
