package org.pure.algorithm.allKindsOfSearch;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-10-11 19:31
 * @description 树表查找
 */
public class TreeSearch {

    // 树表查找基本思想：二叉查找树是先对待查找的数据进行生成树，确保树的左分支的值小于右分支的值，然后在就先和每个节点的父节点比较大小，查找最适合的范围
    // 树表查找算法的查找效率很高，但是如果使用这种查找方法要首先创建树

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();
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

        // 打印二叉树
        System.out.println(Arrays.toString(treeNodeToArray(root)));

        // 获取输出结果
        TreeNode result = treeSearch(root, target);
        if (result != null) {
            System.out.println(result.val + "");
        } else {
            System.out.println("-1");
        }
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

    // 树表查找，二叉树查找，例如：[4,2,6,1,3,5,7]，中序遍历刚好就是[1,2,3,4,5,6,7]
    private static TreeNode treeSearch(TreeNode root, int target) {
        // 定义当前树节点
        TreeNode current = root;

        while (current != null) {
            if (target < current.val) {
                // 若当前值大于查找值，那么搜索左子树
                current = current.left;
            } else if (target > current.val) {
                // 若当前值小于查找值，那么搜索右子树
                current = current.right;
            } else {
                // 若当前值等于目标值，返回树节点
                return current;
            }
        }

        // 若遍历完整个树都没有找到目标值，返回null
        return null;
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
