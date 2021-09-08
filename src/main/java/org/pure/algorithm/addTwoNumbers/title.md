## 源码路径

/src/main/java/org/pure/algorithm/addTwoNumbers/Main.java

## 题目地址(两数相加)

https://leetcode-cn.com/problems/add-two-numbers

## 题目描述

```
给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字0之外，这两个数都不会以0开头。

示例1:

输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807

示例2:

输入：l1 = [0], l2 = [0]
输出：[0]

示例3:

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]

提示:

每个链表中的节点数在范围[1, 100]内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
```

## 代码

- 语言：Java

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // 方法1，不可行
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 方法1，直接把两个链表的值转换出来，两个值相加得到新值，新值再转为链表
        // 此方法不可行，因为在链表转为值时可能会溢出，导致转的值不正确

        // 定义指数，初始为10^0=1
        int e = 1;

        // 定义第一个链表转换出的值
        int num1 = 0;

        // 从头到尾遍历链表，计算出链表对应的值
        do {
            num1 += l1.val * e;
            e *= 10;
            l1 = l1.next;
        } while (l1 != null);
          
        // 指数重置为初始的10^0=1
        e = 1;

        // 定义第二个链表转换出的值
        int num2 = 0;

        // 从头到尾遍历链表，计算出链表对应的值
        do {
            num2 += l2.val * e;
            e *= 10;
            l2 = l2.next;
        } while (l2 != null);

        // 两数相加得到两数之和
        int sum = num1 + num2;

        // 定义计算两数之和的链表的中间节点
        ListNode node = new ListNode();
        // 定义两数之和的链表
        ListNode head = node;

        // 把两数之和转为链表
        do {
            node.val = sum % 10;
            sum /= 10;
            if (sum != 0) {
                node.next = new ListNode();
                node = node.next;
            }
        } while (sum != 0);

        // 返回两数之和的链表
        return head;
    }

}
```

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // 方法2，可行
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 方法2，模拟，按照两数相加的竖式计算的思路走，同时从头到尾遍历两个链表，构造出两数之和的链表

        // 定义计算两数之和的链表的中间节点
        ListNode node = new ListNode();

        // 定义两数之和的链表
        ListNode head = node;

        // 定义是否进位
        boolean isCarry = false;

        // 循环，模拟竖式计算，同时从头到尾遍历两个链表，构造出两数之和的链表，当两个链表都为空时结束循环
        while (l1 != null || l2 != null) {
            // 定义竖式计算时两数相加的结果
            int val = 0;

            // 处理第一个链表
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            // 处理第二个链表
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            // 如果前面有进位，两数相加的结果加1
            val = isCarry ? val + 1 : val;

            // 判断当前位是否有进位，若大于9，则需要进位
            isCarry = val > 9;

            if (val > 9) {
                // 若大于9，则减10取个位数
                val = val - 10;
            }

            // 把两数相加的结果赋给新链表的节点
            node.val = val;

            if (l1 != null || l2 != null) {
                // 若两个链表都为空，那么后面不会再有节点，所以如果新链表后面不进位，那么后面也不会再有节点
                node.next = new ListNode();
                node = node.next;
            }
        }

        if (isCarry) {
            // 如果新链表后面进位，那么要补充一位
            node.next = new ListNode(1);
        }

        // 返回两数之和的链表
        return head;
    }

}
```