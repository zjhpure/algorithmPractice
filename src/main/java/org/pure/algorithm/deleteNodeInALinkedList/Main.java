package org.pure.algorithm.deleteNodeInALinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-06 11:32
 * @description 删除链表中的节点
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 处理输入结果
        ListNode newNode = new ListNode(nums[0]);
        ListNode head = newNode;
        for (int i = 1; i < nums.length; ++i) {
            newNode.next = new ListNode(nums[i]);
            if (i < nums.length - 1) {
                newNode = newNode.next;
            }
        }

        // 处理输入结果
        ListNode findHead = head;
        ListNode node = null;
        while (findHead != null) {
            if (findHead.val == n) {
                node = findHead;
                break;
            }
            findHead = findHead.next;
        }

        if (node != null) {
            // 获取输出结果
            deleteNode(node);
        }

        // 处理输入结果
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        System.out.println(list);
    }

    private static void deleteNode(ListNode node) {
        // 注意：这里传入的参数只有被删除的节点，没有head节点
        // 因为要删除的是非末尾节点，所以删除这个节点就是把这个节点变成下一个节点，再把指针指向下下一个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
