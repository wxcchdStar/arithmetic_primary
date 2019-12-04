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
    System.out.println(wordBreak2("catsanddog", wordDict));
  }

  public static List<String> wordBreak2(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>(wordDict);

    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && set.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    System.out.println(Arrays.toString(dp));

    List<String> res = new ArrayList<>();
    if (dp[s.length()]) {
      LinkedList<String> queue = new LinkedList<>();
      dfs(s, s.length(), set, res, queue, dp);
      return res;
    }

    return res;
  }

  private static void dfs(String s, int end, Set<String> wordSet, List<String> res, LinkedList<String> queue, boolean[] dp) {
    if (end == 0) {
      StringBuilder stringBuilder = new StringBuilder();
      for (String word : queue) {
        stringBuilder.append(word);
        stringBuilder.append(" ");
      }
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
      res.add(stringBuilder.toString());
      return;
    }

    for (int i = 0; i < end; i++) {
      if (dp[i]) {
        String suffix = s.substring(i, end);
        if (wordSet.contains(suffix)) {
          queue.addFirst(suffix);
          dfs(s, i, wordSet, res, queue, dp);
          queue.removeFirst();
        }
      }
    }
  }

  // 超时
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
