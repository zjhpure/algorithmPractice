## 源码路径

/src/main/java/org/pure/algorithm/deleteNodeInALinkedList/Main.java

## 题目地址(删除链表中的节点)

https://leetcode-cn.com/problems/delete-node-in-a-linked-list

## 题目描述

```
请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

现有一个链表 -- head = [4,5,1,9]，它可以表示为:

4-5-1-9

示例1:

输入：head = [4,5,1,9], node = 5
输出：[4,1,9]
解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9。

示例2:

输入：head = [4,5,1,9], node = 1
输出：[4,5,9]
解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9。

提示:

链表至少包含两个节点。
链表中所有节点的值都是唯一的。
给定的节点为非末尾节点并且一定是链表中的一个有效节点。
不要从你的函数中返回任何结果。
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

    public void deleteNode(ListNode node) {
        // 注意：这里传入的参数只有被删除的节点，没有head节点
        // 因为要删除的是非末尾节点，所以删除这个节点就是把这个节点变成下一个节点，再把指针指向下下一个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
```