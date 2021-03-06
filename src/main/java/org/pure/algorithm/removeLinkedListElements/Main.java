package org.pure.algorithm.removeLinkedListElements;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-05 18:15
 * @description 移除链表元素
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int val = scanner.nextInt();
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
        ListNode result = removeElements(head, val);
        List<Integer> list = new ArrayList<>();
        while (result != null) {
            list.add(result.val);
            result = result.next;
        }
        System.out.println(list);
    }

    private static ListNode removeElements(ListNode head, int val) {
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

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
