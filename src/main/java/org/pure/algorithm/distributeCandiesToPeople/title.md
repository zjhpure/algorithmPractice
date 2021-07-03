## 源码路径

/src/main/java/org/pure/algorithm/distributeCandiesToPeople/Main.java

## 题目地址(分糖果II)

https://leetcode-cn.com/problems/distribute-candies-to-people

## 题目描述

```
排排坐，分糖果。

我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。

给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。

然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。

重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。

返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。

示例1:

输入：candies = 7, num_people = 4
输出：[1,2,3,1]
解释：
第一次，ans[0] += 1，数组变为 [1,0,0,0]。
第二次，ans[1] += 2，数组变为 [1,2,0,0]。
第三次，ans[2] += 3，数组变为 [1,2,3,0]。
第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。

示例2:

输入：candies = 10, num_people = 3
输出：[5,2,3]
解释：
第一次，ans[0] += 1，数组变为 [1,0,0]。
第二次，ans[1] += 2，数组变为 [1,2,0]。
第三次，ans[2] += 3，数组变为 [1,2,3]。
第四次，ans[0] += 4，最终数组变为 [5,2,3]。

提示:

1 <= candies <= 10^9
1 <= num_people <= 1000
```

## 代码

- 语言：Java

```
class Solution {

    public int[] distributeCandies(int candies, int num_people) {
        // 定义结果数组results
        int[] results = new int[num_people];

        // 定义结果数组索引
        int index = 0;
        // 定义每次要分糖果
        int n = 1;

        // 循环构造结果数组results，直到糖果candies小于等于0，结束循环
        while (candies > 0) {
            // 获取糖果减去每次要分的糖果
            int remaining = candies - n;

            if (remaining > 0) {
                // 若糖果够减，当前索引的结果数组元素累加每次要分的糖果
                results[index] += n;
                // 糖果更新为减去后的结果
                candies = remaining;
            } else {
                // 若糖果不够减，当前索引的结果数组元素累加剩下的糖果
                results[index] += candies;
                // 糖果设置为0
                candies = 0;
            }

            // 每次要分的糖果自增1
            ++n;
            
            // 结果数组索引往后移动一位，如果到了最后位置，重新回到刚开始位置
            index = index < num_people - 1 ? ++index : 0;
        }
        
        // 返回结果数组
        return results;
    }

}
```