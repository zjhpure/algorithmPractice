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
        TreeNode result = invertTree(root);
        System.out.println(Arrays.toString(treeNodeToArray(result)));
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

    // 翻转二叉树
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            // 若树节点是空，直接返回空
            return null;
        }

        // 利用递归法，把树看成是根节点、左孩子、右孩子的整体，整体翻转根节点的左孩子和右孩子，如果左孩子和右孩子也是树，那么递归下去同样执行相同的方法，直到左孩子和右孩子为空时，递归开始回溯

        // 获取根节点的左孩子
        TreeNode left = invertTree(root.left);

        // 根节点的左孩子等于右孩子，右孩子等于左孩子，实现翻转
        root.left = invertTree(root.right);
        root.right = left;

        // 返回翻转后的根节点
        return root;
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
