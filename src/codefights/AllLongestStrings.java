package codefights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AllLongestStrings {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(allLongestStrings(
                new String[]{"abc", "eeee", "abcd", "dcd"}
        )));
    }

    private static String[] allLongestStrings(String[] inputArray) {
        int max = 0;
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            int length = inputArray[i].length();
            if (map.containsKey(length)) {
                map.get(length).add(inputArray[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(inputArray[i]);
                map.put(length, list);
            }
            if (max < length) {
                max = length;
            }
        }
        ArrayList<String> list = map.get(max);
        if (list != null) {
            String[] result = new String[list.size()];
            return list.toArray(result);
        } else {
            return new String[] {};
        }
    }
}
