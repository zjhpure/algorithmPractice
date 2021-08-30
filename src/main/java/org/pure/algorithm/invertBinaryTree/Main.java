package org.pure.algorithm.invertBinaryTree;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-08-30 17:40
 * @description 翻转二叉树
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 处理输入结果
        int[] nums;
        if ("[]".equals(str)) {
            // 当数组为空
            nums = null;
        } else {
            // 当数组不为空
            String[] strs = str.split("\\[")[1].split("]")[0].split(",");
            int size = strs.length;
            nums = new int[size];
            for (int i = 0; i < size; ++i) {
                nums[i] = Integer.parseInt(strs[i]);
            }
        }

        // 数组转为树
        TreeNode root = arrayToTreeNode(nums);

        // 获取输出结果
        TreeNode result = invertTree(root);
        System.out.println(Arrays.toString(treeNodeToArray(result)));
    }

    // 数组转为树，层次遍历，分层按照从上到下，从左到右的顺序
    private static TreeNode arrayToTreeNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            // 若树节点为空，直接返回空
            return null;
        }

        // 创建树的根节点
        TreeNode root = new TreeNode();

        // 树的根节点为数组第一个元素
        root.val = nums[0];

        // 递归构造树节点
        createTreeNode(root, nums, 1);

        // 返回树的根节点
        return root;
    }

    // 递归构造树节点
    private static void createTreeNode(TreeNode node, int[] nums, int k) {
        if (k * 2 > nums.length) {
            // 若节点的左节点大于了数组范围，递归回溯
            return;
        }

        // 构造节点的左节点
        node.left = new TreeNode();
        // 若节点的值在数组的第k个，那么节点的左节点的值在数组的第k * 2个，下标需要减1，即为k * 2 - 1
        node.left.val = nums[k * 2 - 1];

        if (k * 2 + 1 > nums.length) {
            // 若节点的右节点大于了数组范围，递归回溯
            return;
        }

        // 构造节点的左节点
        node.right = new TreeNode();
        // 若节点的值在数组的第k个，那么节点的左节点的值在数组的第k * 2 - 1个，下标需要减1，即为k * 2
        node.right.val = nums[k * 2];

        // 构造节点的左节点的子节点
        createTreeNode(node.left, nums, k * 2);
        // 构造节点的右节点的子节点
        createTreeNode(node.right, nums, k * 2 + 1);
    }

    // 树转为数组，层序遍历，分层按照从上到下，从左到右的顺序，这里因为是翻转二叉树，需要特殊处理，最后一层空的节点也要显示出来，显示为null，这样才能看出翻转后的二叉树的效果
    private static Integer[] treeNodeToArray(TreeNode root) {
        // 定义两层列表，保存整体结果
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            // 若树节点为空，直接返回空数组
            return new Integer[0];
        }

        // 通过队列辅助，从上到下完成每层的遍历，在每层遍历时，每遍历完一个节点，就确定这个节点的两个子节点，如果不为空，把子节点放进队列后面，队列保证了树按照层次从上到下遍历，每层从左到右遍历

        // 定义队列
        Queue<TreeNode> queue = new LinkedList<>();

        // 先把树的根节点放进队列最后
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
                        // 把当前树节点的左节点放进队列最后
                        queue.add(node.left);
                    } else {
                        // 子节点为空也要放进队列最后，为了适应看出翻转二叉树后的效果
                        queue.add(null);
                    }

                    if (node.right != null) {
                        // 把当前树节点的右节点放进队列最后
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

        // 返回数组
        return nums;
    }

    // 翻转二叉树
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            // 若树节点是空，直接返回空
            return null;
        }

        // 利用递归法，把树看成是根节点、左节点、右节点的整体，整体翻转根节点的左节点和右节点，如果左节点和右节点也是树，那么递归下去同样执行相同的方法，直到左节点和右节点为空时，递归开始回溯

        // 获取根节点的左节点
        TreeNode left = invertTree(root.left);

        // 根节点的左节点等于右节点，右节点等于左节点，实现翻转
        root.left = invertTree(root.right);
        root.right = left;

        // 返回翻转后的根节点
        return root;
    }

}

// 定义树
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
