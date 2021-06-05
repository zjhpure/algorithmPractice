## 源码路径

/src/main/java/org/pure/algorithm/removeLinkedListElements/Main.java

## 题目地址(移除链表元素)

https://leetcode-cn.com/problems/remove-linked-list-elements

## 题目描述

```
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。

示例1:

输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]

示例2:

输入：head = [], val = 1
输出：[]

示例3:

输入：head = [7,7,7,7], val = 7
输出：[]

提示:

列表中的节点在范围 [0, 10^4] 内
1 <= Node.val <= 50
0 <= k <= 50
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

    public ListNode removeElements(ListNode head, int val) {
        // 定义当前节点
        ListNode node = new ListNode();

        // 定义结果，第一个节点指向定义的链表节点
        ListNode resultNode = node;

        // 定义前一个节点，后面用来删除最后的空节点
        ListNode preNode = new ListNode();

        // 定义是否找到符合条件的节点标志
        boolean isFind = false;

        // 遍历链表head的节点
        while (head != null) {
            if (head.val != val) {
                // 如果节点的值不等于val，那么找到了符合条件的节点
                // 把是否找到符合条件的节点标志设置为true
                isFind = true;

                // 把找到的节点的值赋给当前节点的值
                node.val = head.val;
                // 当前节点指向下一个节点的指针创建新的节点对象
                node.next = new ListNode();
                // 把当前节点保存给定义的前一个节点变量
                preNode = node;
                // 当前节点等于自己指向下一个节点的指针指向的节点
                node = node.next;
            }

            // 节点等于下一个节点，往后遍历
            head = head.next;
        }

        // 把前一个节点的指针设置为空，因为最后有一个多余的空节点，通过把前一个节点中指向下一个节点的指针next设置为空，从而删除空节点
        preNode.next = null;

        if (!isFind) {
            // 如果一个符合条件的节点都没有找到，那么把第一个节点设为空
            resultNode = null;
        }

        return resultNode;
    }

}
```