package org.pure.algorithm.linkedListLastKNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-09-02 20:16
 * @description 链表中倒数第k个节点
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        ListNode head = null;
        if (!"[]".equals(str)) {
            String[] strs = str.split("\\[")[1].split("]")[0].split(",");
            int size = strs.length;
            int[] nums = new int[size];
            for (int i = 0; i < size; ++i) {
                nums[i] = Integer.parseInt(strs[i]);
            }

            // 处理输入结果
            ListNode node = new ListNode();
            head = node;
            for (int i = 0; i < nums.length; ++i) {
                node.val = nums[i];
                if (i < nums.length - 1) {
                    node.next = new ListNode();
                    node = node.next;
                }
            }
        }

        // 获取输出结果
        ListNode result = getKthFromEnd(head, k);
        List<Integer> list = new ArrayList<>();
        while (result != null) {
            list.add(result.val);
            result = result.next;
        }
        System.out.println(list);
    }

    private static ListNode getKthFromEnd(ListNode head, int k) {
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

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }
}

