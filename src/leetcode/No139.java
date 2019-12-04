package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 139. 单词拆分
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No139 {

  public static void main(String[] args) {
    List<String> wordDict = new ArrayList<>();
    wordDict.add("leet");
    wordDict.add("code");
    System.out.println(wordBreak2("leetcode", wordDict));
  }

  private static boolean wordBreak2(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>(wordDict);

    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 1; i < s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && set.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }

    return dp[s.length()];
  }

  private static boolean wordBreak(String s, List<String> wordDict) {
    return find(s, wordDict, 0, new Boolean[s.length()]);
  }

  private static boolean find(String s, List<String> wordDict, int start, Boolean[] mem) {
    if (start == s.length()) {
      return true;
    }
    if (mem[start] != null) {
      return mem[start];
    }
    for (int i = start + 1; i <= s.length(); i++) {
      if (wordDict.contains(s.substring(start, i)) && find(s, wordDict, i, mem)) {
        mem[start] = true;
        return true;
      }
    }
    mem[start] = false;
    return false;
  }
}
