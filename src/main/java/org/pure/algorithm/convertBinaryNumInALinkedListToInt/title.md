## 源码路径

/src/main/java/org/pure/algorithm/convertBinaryNumInALinkedListToInt/Main.java

## 题目地址(二进制链表转整数)

https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer

## 题目描述

```
给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。

请你返回该链表所表示数字的 十进制值 。

示例1:

输入：head = [1,0,1]
输出：5
解释：二进制数 (101) 转化为十进制数 (5)

示例2:

输入：head = [0]
输出：0

示例3:

输入：head = [1]
输出：1

示例4:

输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
输出：18880

示例5:

输入：head = [0,0]
输出：0

提示:

链表不为空。
链表的结点总数不超过 30。
每个结点的值不是 0 就是 1。
```

## 代码

- 语言：Java

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public int getDecimalValue(ListNode head) {
        // 定义列表list，保存链表整数
        List<Integer> list = new ArrayList<>();

        // 遍历链表head，把链表的整数保存到列表list
        do {
            list.add(head.val);
            head = head.next;
        } while (head != null);

        // 定义十进制值
        int num = 0;
        // 定义2的n次幂，2^0=1，初始值为1
        int e = 1;

        // 遍历列表list，从尾到头
        for (int i = list.size() - 1; i >= 0; --i) {
            // 二进制转十进制，2的n次幂从尾到头开始数，每一位的幂加1，每一次都用2的n次幂乘以位的值，各个位的结果相加等于十进制结果
            num = num + list.get(i) * e;
            // 每进一位，2的n次幂就多一次幂
            e *= 2;
        }

        return num;
    }

}
```