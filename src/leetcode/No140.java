package leetcode;

import java.util.*;

/**
 * 140. 单词拆分 II
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No140 {

  public static void main(String[] args) {
    List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
    System.out.println(wordBreak("catsandgog", wordDict));
  }

  public static List<String> wordBreak(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>(wordDict);

    List<String>[] dp = new List[s.length() + 1];
    dp[0] = Collections.singletonList("");

    for (int i = 1; i <= s.length(); i++) {
      List<String> list = new ArrayList<>();
      for (int j = 0; j < i; j++) {
        if (!dp[j].isEmpty() && set.contains(s.substring(j, i))) {
          for (String str : dp[j]) {
            list.add((str + " " + s.substring(j, i)).trim());
          }
        }
      }
      dp[i] = list;
    }

    return dp[s.length()];
  }
}
