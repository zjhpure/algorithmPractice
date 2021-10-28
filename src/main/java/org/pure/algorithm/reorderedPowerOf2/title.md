## 源码路径

/src/main/java/org/pure/algorithm/reorderedPowerOf2/Main.java

## 题目地址(重新排序得到2的幂)

https://leetcode-cn.com/problems/reordered-power-of-2

## 题目描述

```
给定正整数N，我们按任何顺序(包括原始顺序)将数字重新排序，注意其前导数字不能为零。

如果我们可以通过上述方式得到2的幂，返回true；否则，返回false。

示例1:

输入：1
输出：true

示例2:

输入：10
输出：false

示例3:

输入：16
输出：true

示例4:

输入：24
输出：false

示例5:

输入：46
输出：true

提示：

1 <= N <= 10^9
```

## 代码

- 语言：Java

```
class Solution {

    // 方法1，不可行，运行超时
    public boolean reorderedPowerOf2(int n) {
        // 思路：先判断一次数字本身是否为2的幂，若是2的幂，直接返回true，结束程序；否则，通过不断对10取余和除以10获取到每个位的数字，保存到列表中，对列表的下标进行全排列，获得全排列结果列表，遍历全排列的结果列表，逐个判断是否是2的幂，若有一个是2的幂，那么返回true，结束程序，若没有一个是2的幂，那么最后返回false，结束程序
        // 不过很可惜，这种思路的代码运行超时，所以不能使用这种方法

        if (n >= 1 && (n & (n - 1)) == 0) {
            // 先判断一次原来的数字是否是2的幂
            return true;
        }

        // 定义列表，保存数字每个位的数字
        List<Integer> list = new ArrayList<>();

        // 不断对10取余，然后除以10，把数字每个位的数字保存进列表中
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }

        // 定义结果列表
        List<List<Integer>> dataList = new ArrayList<>();

        // 定义每种顺序的下标列表
        List<Integer> indexList = new ArrayList<>();

        // 对列表下标进行全排列，初始层数0
        arrange(dataList, indexList, list, 0);

        // 遍历结果列表，判断是否存在2的幂
        for (List<Integer> data : dataList) {
            // 前导数字不能为零
            if (list.get(data.get(0)) != 0) {
                // 定义列表中数字组成的数字
                int num = 0;

                // 定义位
                int e = 1;

                // 列表中各位的数字转为数字
                for (int i = data.size() - 1; i >= 0; --i) {
                    num += list.get(data.get(i)) * e;
                    e *= 10;
                }

                // 判断是否是2的幂，若存在2的幂，返回true
                if (num >= 1 && (num & (num - 1)) == 0) {
                    return true;
                }
            }
        }

        // 若遍历完结果列表也没有找到2的幂，那么返回false
        return false;
    }

    // 全排列函数，递归，回溯算法
    // 想象成树，遍历列表list就是以哪个元素开头，用一个列表保存每次排列的结果，找到一次结果后删除最后元素进行回溯，逐步向上回溯
    private void arrange(List<List<Integer>> dataList, List<Integer> indexList, List<Integer> list, int n) {
        if (n == list.size()) {
            // 若层数达到了列表list的长度，结果列表添加元素，结束函数
            dataList.add(new ArrayList<>(indexList));
            return;
        }

        // 遍历数组nums
        for (int i = 0; i < list.size(); ++i) {
            if (indexList.contains(i)) {
                // 重复元素不添加，直接跳过
                continue;
            }

            // 每条结果列表添加元素，这里保存的是下标
            indexList.add(i);

            // 递归调用，n增加一层
            arrange(dataList, indexList, list, n + 1);

            // 每条结果列表去掉最后一个元素，进行回溯
            indexList.remove(indexList.size() - 1);
        }
    }

}
```

```
class Solution {

    // 方法2，推荐
    public boolean reorderedPowerOf2(int n) {
        // 思路：预处理+哈希表，此方法比较高效，因为范围是1 <= N <= 10^9，这个范围内2的幂也没有多少个，可以先列举出来，记录每个2的幂中各种数字出现的次数，利用计数排序的思想记录次数，因为数字的范围是0-9，所以定义一个长度为10的字符数组，在数组对应的下标的元素里记录数字出现的次数，再把字符数组保存成字符串，把字符串放到哈希表中，最后用同样的方法统计n中各种数字出现的次数，得到一个字符串，如果这个字符串在哈希表中能找到，那么代表n中的数字可以通过重新排序得到2的幂，否则不能

        if (n >= 1 && (n & (n - 1)) == 0) {
             // 先判断一次原来的数字是否是2的幂
            return true;
        }

        // 定义哈希表，保存范围内所有2的幂中各种数字出现的次数，用字符串表示
        Set<String> countDigitSet = new HashSet<>();

        // 从1遍历到10^9，找出范围所有2的幂，
        for (int i = 1; i <= 1e9; i <<= 1) {
            // 从1开始，每次乘以2，也就是位向左移动1位，然后统计这个数字中各位的各种数字出现的次数，把结果转成字符串，保存到哈希表中
            countDigitSet.add(countDigit(i));
        }

        // 同样统计n中各位的各种数字出现的次数，把结果转成字符串，若这个字符串在哈希表中能找到，那么代表n中的数字可以通过重新排序得到2的幂，否则不能
        return countDigitSet.contains(countDigit(n));
    }

    // 输入一个数字，统计这个数字中各位的各种数字出现的次数，把结果转成字符串返回
    private String countDigit(int n) {
        // 定义长度为10的字符数组，因为数字的范围是0-9，利用计数排序的思想记录次数，在数组对应的下标的元素里记录数字出现的次数
        char[] result = new char[10];

        // 循环，数字n不断对10取余，不断除以10，逐个得到各个位上的数字
        while (n > 0) {
            // 通过当前位的数字找到对应的下标，此下标的元素记录数字出现次数，每次加1
            ++result[n % 10];
            // 除以10，直到缩小到0
            n /= 10;
        }

        // 字符数组转为字符串
        return new String(result);
    }

}
```