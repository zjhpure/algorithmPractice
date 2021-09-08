package org.pure.algorithm.addTwoNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-09-08 17:21
 * @description 两数相加
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        ListNode l1;
        if (!"[]".equals(str1)) {
            String[] strs = str1.split("\\[")[1].split("]")[0].split(",");
            int size = strs.length;
            int[] nums = new int[size];
            for (int i = 0; i < size; ++i) {
                nums[i] = Integer.parseInt(strs[i]);
            }

            // 处理输入结果
            ListNode node = new ListNode();
            l1 = node;
            for (int i = 0; i < nums.length; ++i) {
                node.val = nums[i];
                if (i < nums.length - 1) {
                    node.next = new ListNode();
                    node = node.next;
                }
            }
        } else {
            l1 = new ListNode();
        }

        // 处理输入结果
        ListNode l2;
        if (!"[]".equals(str2)) {
            String[] strs = str2.split("\\[")[1].split("]")[0].split(",");
            int size = strs.length;
            int[] nums = new int[size];
            for (int i = 0; i < size; ++i) {
                nums[i] = Integer.parseInt(strs[i]);
            }

            // 处理输入结果
            ListNode node = new ListNode();
            l2 = node;
            for (int i = 0; i < nums.length; ++i) {
                node.val = nums[i];
                if (i < nums.length - 1) {
                    node.next = new ListNode();
                    node = node.next;
                }
            }
        } else {
            l2 = new ListNode();
        }

        // 获取输出结果
        ListNode result = addTwoNumbers(l1, l2);
        List<Integer> list = new ArrayList<>();
        while (result != null) {
            list.add(result.val);
            result = result.next;
        }
        System.out.println(list);
    }

//    // 方法1，不可行
//    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        // 方法1，直接把两个链表的值转换出来，两个值相加得到新值，新值再转为链表
//        // 此方法不可行，因为在链表转为值时可能会溢出，导致转的值不正确
//
//        // 定义指数，初始为10^0=1
//        int e = 1;
//
//        // 定义第一个链表转换出的值
//        int num1 = 0;
//
//        // 从头到尾遍历链表，计算出链表对应的值
//        do {
//            num1 += l1.val * e;
//            e *= 10;
//            l1 = l1.next;
//        } while (l1 != null);
//
//        // 指数重置为初始的10^0=1
//        e = 1;
//
//        // 定义第二个链表转换出的值
//        int num2 = 0;
//
//        // 从头到尾遍历链表，计算出链表对应的值
//        do {
//            num2 += l2.val * e;
//            e *= 10;
//            l2 = l2.next;
//        } while (l2 != null);
//
//        // 两数相加得到两数之和
//        int sum = num1 + num2;
//
//        // 定义计算两数之和的链表的中间节点
//        ListNode node = new ListNode();
//        // 定义两数之和的链表
//        ListNode head = node;
//
//        // 把两数之和转为链表
//        do {
//            node.val = sum % 10;
//            sum /= 10;
//            if (sum != 0) {
//                node.next = new ListNode();
//                node = node.next;
//            }
//        } while (sum != 0);
//
//        // 返回两数之和的链表
//        return head;
//    }

    // 方法2，可行
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
