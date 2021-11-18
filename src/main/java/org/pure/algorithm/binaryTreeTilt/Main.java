package org.pure.algorithm.binaryTreeTilt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-18 08:52
 * @description 二叉树的坡度
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 处理输入结果
        Integer[] nums;
        if ("[]".equals(str)) {
            // 当数组为空
            nums = null;
        } else {
            // 当数组不为空
            String[] strs = str.split("\\[")[1].split("]")[0].split(",");
            int size = strs.length;
            nums = new Integer[size];
            for (int i = 0; i < size; ++i) {
                if ("null".equals(strs[i])) {
                    nums[i] = null;
                } else {
                    nums[i] = Integer.parseInt(strs[i]);
                }
            }
        }

        // 数组转为二叉树
        TreeNode root = arrayToTreeNode(nums);

        // 获取输出结果
        int result = findTilt(root);
        System.out.println(result);
    }

    // 数组转为二叉树，层序遍历，分层按照从上到下，从左到右的顺序
    private static TreeNode arrayToTreeNode(Integer[] nums) {
        // 利用队列辅助，特别需要注意支持数组元素为null，当数组元素为null时，该节点没有孩子，但是自身会占用一个数组元素
        // 如果该节点的左孩子为null，右孩子不为null，那么数组的下一个元素会从右孩子的子节点开始，因为左孩子为null，没有子节点
        // 例子：[0,null,2,null,4,null,6]，[1,null,2,3]，[0,1,null,null,4]，[4,2,7,1,3,6,9]

        if (nums == null || nums.length == 0) {
            // 若二叉树节点为空，直接返回空
            return null;
        }

        // 数组的开始下标
        int i = 1;

        // 先构造二叉树根节点
        TreeNode root = new TreeNode(nums[0]);

        // 定义当前的二叉树节点，保存临时值
        TreeNode current;

        // 定义当前数组的值
        Integer value;

        // 定义队列，层序遍历创建二叉树
        Queue<TreeNode> queue = new LinkedList<>();

        // 先把二叉树根节点放进队列最后
        queue.add(root);

        // 遍历数组，构造二叉树
        while (i < nums.length) {
            // 队列出列第一个元素，获取当前二叉树节点
            current = queue.poll();

            // 获取数组的值，数组下标加1
            value = nums[i++];

            if (value != null) {
                // 创建当前二叉树节点的左孩子
                TreeNode left = new TreeNode(value);

                if (current != null) {
                    // 构造当前二叉树节点的左孩子
                    current.left = left;
                }

                // 把当前二叉树节点的左孩子放进队列最后
                queue.add(left);
            }

            if (i < nums.length) {
                // 获取数组的值，数组下标加1
                value = nums[i++];

                if (value != null) {
                    // 创建当前二叉树节点的右孩子
                    TreeNode right = new TreeNode(value);

                    if (current != null) {
                        // 构造当前二叉树节点的右孩子
                        current.right = right;
                    }

                    // 把当前二叉树节点的右孩子放进队列最后
                    queue.add(right);
                }
            }
        }

        // 返回二叉树的根节点
        return root;
    }

    // 模拟法

    // 定义坡度之和
    private static int sum = 0;
    // 定义左子树节点之和
    private static int leftSum = 0;
    // 定义右子树节点之和
    private static int rightSum = 0;

    private static int findTilt(TreeNode root) {
        // 递归遍历二叉树，计算整个二叉树的坡度之和
        traversal(root);

        // 返回坡度之和
        return sum;
    }

    // 通过递归遍历二叉树，计算每一个节点的坡度
    private static void traversal(TreeNode root) {
        if (root == null) {
            // 当节点为空时，跳出递归
            return;
        }

        // 左子树节点之和归零
        leftSum = 0;
        // 右子树节点之和归零
        rightSum = 0;

        // 获取左子树的节点之和
        getSum(root.left, true);
        // 获取右子树的节点之和
        getSum(root.right, false);

        // 计算左子树的节点之和和右子树的节点之和的差的绝对值
        sum += Math.abs(leftSum - rightSum);

        // 跳到当前节点的左子树
        traversal(root.left);
        // 跳到当前节点的右子树
        traversal(root.right);
    }

    // 获取当前节点之和
    private static void getSum(TreeNode node, boolean isLeft) {
        if (node == null) {
            // 当节点为空时，跳出递归
            return;
        }

        if (isLeft) {
            // 计算左节点
            leftSum += node.val;
        } else {
            // 计算右节点
            rightSum += node.val;
        }

        // 计算当前节点的左子树
        getSum(node.left, isLeft);
        // 计算当前节点的右子树
        getSum(node.right, isLeft);
    }

}

// 定义二叉树
class TreeNode {

    int val;

    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
