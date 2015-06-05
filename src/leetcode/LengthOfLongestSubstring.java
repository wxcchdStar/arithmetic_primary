package leetcode;

import java.util.HashMap;

public class LengthOfLongestSubstring {
	
	public static void main(String[] args) {
		
	}
	
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) return s.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
	
}
