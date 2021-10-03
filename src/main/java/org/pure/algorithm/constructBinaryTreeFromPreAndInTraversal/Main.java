package org.pure.algorithm.constructBinaryTreeFromPreAndInTraversal;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-10-02 17:44
 * @description 从前序与中序遍历序列构造二叉树
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

    // 定义哈希表，方便快速定位根节点
    private static Map<Integer, Integer> indexMap = new HashMap<>();

    // 构建树
    private static TreeNode myBuildTree(int[] preorder, int preorderLeft, int preorderRight, int inorderLeft) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 在中序遍历中定位根节点，根据前序遍历的值找到在中序遍历中这个值的下标
        int inorderRoot = indexMap.get(preorder[preorderLeft]);

        // 定义根节点，根节点的值就是前序遍历中的第一个节点
        TreeNode root = new TreeNode(preorder[preorderLeft]);

        // 得到左子树中的节点数目
        int sizeLeftSubtree = inorderRoot - inorderLeft;

        // 递归地构造左子树，并连接到根节点
        // 前序遍历：从左边界+1开始的sizeLeftSubtree个元素，对应中序遍历：从左边界开始到根节点定位-1的元素
        root.left = myBuildTree(preorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft);

        // 递归地构造右子树，并连接到根节点
        // 前序遍历：从左边界+1+左子树节点数目开始到右边界的元素，对应中序遍历：从根节点定位+1到右边界的元素
        root.right = myBuildTree(preorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1);

        return root;
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            // 若前序遍历数组或中序遍历数组为空，那么树也是空的
            return null;
        }

        // 获取前序遍历数组的长度
        int n = preorder.length;

        // 把中序遍历数组的信息保存到哈希表
        for (int i = 0; i < n; i++) {
            // 把数组的元素和数组的下标保存进哈希表
            indexMap.put(inorder[i], i);
        }

        // 构建树
        return myBuildTree(preorder, 0, n - 1, 0);
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
