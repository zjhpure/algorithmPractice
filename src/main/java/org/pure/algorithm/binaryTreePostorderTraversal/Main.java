package org.pure.algorithm.binaryTreePostorderTraversal;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-09-06 21:27
 * @description 二叉树的后序遍历
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
        List<Integer> result = postorderTraversal(root);
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

//    // 二叉树的后序遍历，方法1，递归法
//    private static List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//
//        // 后序遍历二叉树
//        postTraversal(list, root);
//
//        return list;
//    }
//
//    // 后序遍历二叉树，递归法
//    private static void postTraversal(List<Integer> list, TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        // 处理左节点
//        postTraversal(list, root.left);
//        // 处理右节点
//        postTraversal(list, root.right);
//        // 根节点添加到列表中
//        list.add(root.val);
//    }

    // 二叉树的后序遍历，方法2，迭代法
    private static List<Integer> postorderTraversal(TreeNode root) {
        // 迭代法，使用栈辅助

        // 定义列表，保存二叉树的中序遍历的结果
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            // 若二叉树为空，直接返回空列表
            return list;
        }

        // 定义栈
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;

        // 当栈为空时，结束循环
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }

        // 返回列表
        return list;
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
