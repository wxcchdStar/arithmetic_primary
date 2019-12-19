package leetcode;

import java.util.*;

/**
 * 752. 打开转盘锁
 * <p>
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 * <p>
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No752 {

  public static void main(String[] args) {
//    System.out.println(new No752().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    System.out.println(new No752().openLock(new String[]{"0000"}, "8888"));
  }

  public int openLock(String[] deadends, String target) {
    HashSet<String> set = new HashSet<>();
    for (String str : deadends) {
      set.add(str);
    }
    if (set.contains("0000")) {
      return -1;
    }

    int count = 0;
    int[] mem = new int[10000];
    Queue<String> queue = new LinkedList<>();
    queue.add("0000");

    while (!queue.isEmpty()) {
      count++;
      int size = queue.size();
      for (int j = 0; j < size; j++) {
        String item = queue.poll();
        for (int i = 0; i < 4; i++) {
          String prefix = item.substring(0, i);
          char c = item.charAt(i);
          String suffix = item.substring(i + 1);

          // +
          String cur;
          if (c == '9') {
            cur = prefix + "0" + suffix;
          } else {
            cur = prefix + (char) (c + 1) + suffix;
          }
          if (!set.contains(cur)) {
            if (cur.equals(target)) {
              return count;
            } else {
              int k = Integer.parseInt(cur);
              if (mem[k] != 1) {
                mem[k] = 1;
                queue.add(cur);
              }
            }
          }

          // -
          if (c == '0') {
            cur = prefix + "9" + suffix;
          } else {
            cur = prefix + (char) (c - 1) + suffix;
          }
          if (!set.contains(cur)) {
            if (cur.equals(target)) {
              return count;
            } else {
              int k = Integer.parseInt(cur);
              if (mem[k] != 1) {
                mem[k] = 1;
                queue.add(cur);
              }
            }
          }
        }
      }
    }
    return -1;
  }

}
