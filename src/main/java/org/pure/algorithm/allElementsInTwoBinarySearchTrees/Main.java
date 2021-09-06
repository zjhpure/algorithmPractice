package org.pure.algorithm.allElementsInTwoBinarySearchTrees;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-09-06 01:22
 * @description 两棵二叉搜索树中的所有元素
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        Integer[] nums1;
        if ("[]".equals(str1)) {
            // 当数组为空
            nums1 = null;
        } else {
            // 当数组不为空
            String[] strs = str1.split("\\[")[1].split("]")[0].split(",");
            int size = strs.length;
            nums1 = new Integer[size];
            for (int i = 0; i < size; ++i) {
                if ("null".equals(strs[i])) {
                    nums1[i] = null;
                } else {
                    nums1[i] = Integer.parseInt(strs[i]);
                }
            }
        }

        // 处理输入结果
        Integer[] nums2;
        if ("[]".equals(str2)) {
            // 当数组为空
            nums2 = null;
        } else {
            // 当数组不为空
            String[] strs = str2.split("\\[")[1].split("]")[0].split(",");
            int size = strs.length;
            nums2 = new Integer[size];
            for (int i = 0; i < size; ++i) {
                if ("null".equals(strs[i])) {
                    nums2[i] = null;
                } else {
                    nums2[i] = Integer.parseInt(strs[i]);
                }
            }
        }

        // 数组转为二叉树
        TreeNode root1 = arrayToTreeNode(nums1);
        TreeNode root2 = arrayToTreeNode(nums2);

        // 获取输出结果
        List<Integer> result = getAllElements(root1, root2);
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

    // 定义列表，用来保存结果
    private static List<Integer> list = new ArrayList<>();

    // 获取两棵二叉搜索树中的所有元素
    private static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // 前序遍历第一棵二叉搜索树
        inOrder(root1);
        // 前序遍历第二棵二叉搜索树
        inOrder(root2);
        // 对列表排序
        Collections.sort(list);
        // 返回排序好的列表
        return list;
    }

    // 前序遍历
    private static void inOrder(TreeNode root) {
        if (root == null) {
            // 若节点为空，返回结束
            return;
        }

        // 添加节点的值到列表中
        list.add(root.val);
        // 前序遍历左节点
        inOrder(root.left);
        // 前序遍历右节点
        inOrder(root.right);
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

