package leetcode

/**
 * 39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
[7],
[2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    for (value in candidates) {
        val temp = mutableListOf<Int>()
        temp.add(value)
        findResult(result, temp, candidates, target, value)
    }
    return result
}

fun findResult(result: MutableList<List<Int>>, temp: MutableList<Int>, candidates: IntArray, target: Int, value: Int) {
    temp.sort()

    if (target - value == 0) {
        for (list in result) {
            if (list == temp) {
                return
            }
        }
        result.add(temp)
        return
    } else if (target - value < 0) {
        return
    }

    for (item in candidates) {
        // 剪枝：数组应该是升序的
        if (temp[temp.size - 1] >= item) {
            val temp2 = mutableListOf<Int>()
            temp2.addAll(temp)
            temp2.add(item)
            findResult(result, temp2, candidates, target - value, item)
        }
    }
}

fun main(args: Array<String>) {
    println(combinationSum(intArrayOf(2, 3, 6, 7), 7))
    println(combinationSum(intArrayOf(2, 3, 5), 8))
}