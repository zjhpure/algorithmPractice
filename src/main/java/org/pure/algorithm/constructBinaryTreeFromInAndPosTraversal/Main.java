package org.pure.algorithm.constructBinaryTreeFromInAndPosTraversal;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-10-03 20:49
 * @description 从中序与后序遍历序列构造二叉树
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        int[] nums1;
        if ("[]".equals(str1)) {
            // 当数组为空
            nums1 = null;
        } else {
            // 当数组不为空
            String[] strs = str1.split("\\[")[1].split("]")[0].split(",");
            int size = strs.length;
            nums1 = new int[size];
            for (int i = 0; i < size; ++i) {
                nums1[i] = Integer.parseInt(strs[i]);
            }
        }

        // 处理输入结果
        int[] nums2;
        if ("[]".equals(str2)) {
            // 当数组为空
            nums2 = null;
        } else {
            // 当数组不为空
            String[] strs = str2.split("\\[")[1].split("]")[0].split(",");
            int size = strs.length;
            nums2 = new int[size];
            for (int i = 0; i < size; ++i) {
                nums2[i] = Integer.parseInt(strs[i]);
            }
        }

        // 获取输出结果
        TreeNode result = buildTree(nums1, nums2);
        System.out.println(Arrays.toString(treeNodeToArray(result)));
    }

    // 二叉树转为数组，层序遍历，分层按照从上到下，从左到右的顺序，这里因为是翻转二叉树，需要特殊处理，最后一层空的节点也要显示出来，显示为null，这样才能看出翻转后的二叉树的效果
    private static Integer[] treeNodeToArray(TreeNode root) {
        // 定义两层列表，保存整体结果
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            // 若二叉树节点为空，直接返回空数组
            return new Integer[0];
        }

        // 通过队列辅助，从上到下完成每层的遍历，在每层遍历时，每遍历完一个节点，就确定这个节点的两个子节点，如果不为空，把子节点放进队列后面，队列保证了树按照层次从上到下遍历，每层从左到右遍历

        // 定义队列
        Queue<TreeNode> queue = new LinkedList<>();

        // 先把二叉树的根节点放进队列最后
        queue.add(root);

        // 循环，直到队列的长度为零，结束循环
        while (queue.size() > 0) {
            // 定义内层列表，保存内层结果
            List<Integer> temp = new ArrayList<>();

            // 获取队列的长度
            int size = queue.size();

            // 遍历队列，每次遍历完成一层树节点的遍历
            for (int i = 0; i < size; ++i) {
                // 队列出列第一个元素
                TreeNode node = queue.poll();

                if (node != null) {
                    // 把出列的元素的值添加到内层列表
                    temp.add(node.val);

                    if (node.left != null) {
                        // 把当前二叉树节点的左孩子放进队列最后
                        queue.add(node.left);
                    } else {
                        // 子节点为空也要放进队列最后，为了适应看出翻转二叉树后的效果
                        queue.add(null);
                    }

                    if (node.right != null) {
                        // 把当前二叉树节点的右孩子放进队列最后
                        queue.add(node.right);
                    } else {
                        // 子节点为空也要放进队列最后，为了适应看出翻转二叉树后的效果
                        queue.add(null);
                    }
                } else {
                    // 把空值添添加到内层列表，为了适应看出翻转二叉树后的效果
                    temp.add(null);
                }
            }

            // 内层列表是否全部元素都是空
            boolean isAllNull = true;

            // 判断内层列表是否全部元素都是空，如果全部元素都是空，那么这一行的内层列表数据是多出的
            for (Integer col : temp) {
                if (col != null) {
                    // 只要有一个元素不是空，那么就不是全部元素都是空
                    isAllNull = false;
                    break;
                }
            }

            if (!isAllNull) {
                // 不是全部元素都是空的内层列表，才添加进两层列表
                list.add(temp);
            }
        }

        // 打印两层列表形式的层序遍历结果
        System.out.println("treeNodeToArray list:" + list);

        // 定义数组的长度
        int count = 0;

        // 遍历两层列表，计算出数组的长度
        for (List<Integer> row : list) {
            // 每行列表的长度累加
            count += row.size();
        }

        // 定义数组
        Integer[] nums = new Integer[count];

        // 定义数组的下标
        int n = 0;

        // 遍历两层列表，把两层列表转为数组
        for (List<Integer> row : list) {
            for (Integer col : row) {
                nums[n++] = col;
            }
        }

        if (nums[nums.length - 1] == null) {
            // 若最后一个元素是null，删除最后一个元素，这种情况肯定是null落在右节点上，而且最后的位置，最后一个元素是null不要保留，如果null在左边才是要保留的
            return Arrays.copyOf(nums, nums.length - 1);
        }

        // 返回数组
        return nums;
    }

    private static int postIdx;

    private static Map<Integer, Integer> idxMap = new HashMap<>();

    private static TreeNode helper(int inLeft, int inRight, int[] postorder) {
        // 如果这里没有节点构造二叉树了，就结束
        if (inLeft > inRight) {
            return null;
        }

        // 选择postIdx位置的元素作为当前子树根节点
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);

        // 根据root所在位置分成左右两棵子树
        int index = idxMap.get(rootVal);

        // 下标减1
        --postIdx;

        // 构造右子树
        root.right = helper(index + 1, inRight, postorder);

        // 构造左子树
        root.left = helper(inLeft, index - 1, postorder);

        return root;
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            // 若中序遍历数组或后序遍历数组为空，那么树也是空的
            return null;
        }

        // 从后序遍历的最后一个元素开始
        postIdx = postorder.length - 1;

        // 建立(元素，下标)键值对的哈希表
        int idx = 0;

        for (Integer val : inorder) {
            idxMap.put(val, idx++);
        }

        return helper(0, inorder.length - 1, postorder);
    }

}

// Definition for a binary tree node.
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
