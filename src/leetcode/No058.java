package leetcode;

/**
 * 58. 最后一个单词的长度
 * <p>
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 */
public class No058 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Today is a nice day"));
    }

    // 还可以倒序便利
    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return 0;

        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                if (count > 0) {
                    max = count;
                }
                count = 0;
            }
        }
        return count == 0 ? max : count;
    }
}
