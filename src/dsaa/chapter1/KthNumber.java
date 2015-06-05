package dsaa.chapter1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ��һ����������ĵ�K�������
 *
 * Created by ChenHd on 2015/5/13.
 */
public class KthNumber {

    public static void main(String[] args) {
        int[] arr = new int[] { 8, 21, 1, 5, 8, 9, 10, 2 };
        System.out.println("getKthNumberBySort:");
        System.out.println(String.format("The %d\'th number is %s", 3, getKthNumberBySort(arr.clone(), 3)));
        System.out.println("getKthNumber2:");
        System.out.println(String.format("The %d\'th number is %s", 3, getKthNumber2(arr.clone(), 3)));
        System.out.println("QuickSelect:");
//        System.out.println(String.format("The %d\'th number is %s", 3, ));
        firstKMaxValue(arr.clone(), 0, arr.length - 1, 2);
    }

    /**
     * 1.�Ƚ�����ݼ�����Ȼ���������±�Ϊ��k-1��������Ϊ��k�������
     * @param arr
     * @param k
     * @return
     */
    public static Integer getKthNumberBySort(int[] arr, int k) {
        Integer result = null;
        if (arr != null && arr.length > 0 && arr.length >= k) {
            Arrays.sort(arr);
            return arr[arr.length - k];
        }
        return result;
    }

    /**
     * 2.�Ƚ�ǰk�������ݼ���������Ȼ��ʣ�µ�����������룬
     *   ������С�������е�k����ʱ����ԣ�������ŵ���������ȷ��λ���ϣ�ͬʱ�������е�һ��Ԫ�ؼ������顣
     *   ���㷨��ֹʱ��λ�ڵ�k��λ���ϵ�Ԫ�ؼ��ǵ�k�������
     * @param arr
     * @param k
     * @return
     */
    public static Integer getKthNumber2(int[] arr, int k) {
        Integer result = null;
        if (arr != null && arr.length > 0 && arr.length >= k && k >= 1) {
            Arrays.sort(arr, 0, k);
            for (int i = k; i < arr.length; i++) {
                int t = arr[i];
                for (int j = k - 1; j >= 0; j--) {
                    if (t > arr[j]) {
                        arr[j] ^= t;
                        t ^= arr[j];
                        arr[j] ^= t;
                    }
                }
            }
            result = arr[0];
        }
        return result;
    }

    /**
     * ʹ�ÿ���ѡ��ط�ʽ����ȥ����k�������
     * @param array
     * @param start
     * @param end
     * @param k
     */
    public static int firstKMaxValue(int[] array, int start, int end, int k) {
        if (start > end) { // ��������
            return -1;
        }
        // ����Ϊstart��ֵ��Ϊ����ֵ
        int div = array[start];
        int j = start; // ��Ϊ����ֵ������
        // ����ѭ���������Ϊ������,��߲��ִ��ڷ���ֵ,�ұ߲���С�ڵ��ڷ���ֵ
        // �Ƚ�start-end������ֺã����array[start]�����м�
        for (int i = start + 1; i <= end; i++) {
            if (array[i] > div) {
                j++;
                if (j != i) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        array[start] = array[j];
        array[j] = div;

        System.out.println(Arrays.toString(array));

        // ��ʱ����ֵ�������������ж�Ӧ��λ���ϣ������ֵ�������еĵ�2��Ԫ�أ���ôj��Ӧ�õ���1��
        // ���j<k������array[j+1]��Ϊ����ֵ�����»����Ҳ�������
        // ���j>k������array[start]��Ϊ����ֵ�����»����󲿷����顣
        //      ע�������array[start]��ԭʼ�����array[start]��ֵ�����ǲ�ͬ�ġ�
        // ���j=k���ͼ�����������е�K��k>=0�����������ֵ��
        if (j < k) {
            return firstKMaxValue(array, j+1, end, k);
        } else if (j > k) {
            return firstKMaxValue(array, start, j-1, k);
        } else {
            System.out.println(j+"," +k+"," +array[j]);
            return array[j];
        }
    }

}