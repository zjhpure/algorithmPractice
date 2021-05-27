package org.pure.algorithm.convertBinaryNumInALinkedListToInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-27 08:15
 * @description 二进制链表转整数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 处理输入结果
        ListNode node = new ListNode(nums[0]);
        ListNode head = node;
        for (int i = 1; i < nums.length; ++i) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }

        // 获取输出结果
        int result = getDecimalValue(head);
        System.out.println(result);
    }

    private static int getDecimalValue(ListNode head) {
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

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
