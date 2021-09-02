## 源码路径

/src/main/java/org/pure/algorithm/linkedListLastKNode/Main.java

## 题目地址(链表中倒数第k个节点)

https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof

## 题目描述

```
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

示例:

给定一个链表: 1->2->3->4->5, 和k = 2.

返回链表 4->5.
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

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 定义链表长度
        int totalCount = 0;

        // 把链表赋给一个新链表，用来统计链表长度
        ListNode node = head;

        // 遍历新链表，从头到尾，统计链表长度
        do {
            // 链表长度加1
            ++totalCount;
            // 新链表往后移动一位
            node = node.next;
        } while (node != null);

        // 遍历原链表，从头到尾，找出倒数第k个节点，遍历时链表长度不断减1
        do {
            if (totalCount <= k) {
                // 若链表长度小于等于k，那么找到了倒数第k个节点
                return head;
            }
            // 链表长度减1
            --totalCount;
            // 原链表往后移动一位
            head = head.next;
        } while (head != null);

        return null;
    }

}
```