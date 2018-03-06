package codefights;

public class MatrixElementsSum {

    // 关键点在于如何按列读取数组
    public static void main(String[] args) {
        System.out.println(matrixElementsSum(new int[][]{
                {1, 1, 1, 0},
                {0, 5, 0, 1},
                {2, 1, 3, 10}
        }));
        System.out.println(matrixElementsSum(new int[][]{
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        }));
    }

    private static int matrixElementsSum(int[][] matrix) {
        int price = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] > 0) {
                    price += matrix[i][j];
                    continue;
                }
                break;
            }
        }
        return price;
    }

}
