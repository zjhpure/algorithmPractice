package org.pure.algorithm.maximumDepthOfNAryTree;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-11-21 15:38
 * @description N叉树的最大深度
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

        // 数组转为N叉树
        Node root = arrayToTreeNode(nums);

        // 获取输出结果
        int result = maxDepth(root);
        System.out.println(result);
    }

    // 数组转为N叉树，层序遍历，分层按照从上到下，从左到右的顺序
    private static Node arrayToTreeNode(Integer[] nums) {
        // 利用队列辅助，N叉树输入按层序遍历序列化表示，每组子节点由空值分隔
        // 例子：[1,null,3,2,4,null,5,6]，[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]

        if (nums == null || nums.length == 0) {
            // 若N叉树节点为空，直接返回空
            return null;
        }

        // 数组的开始下标
        int i = 1;

        // 先构造N叉树根节点
        Node root = new Node(nums[0]);

        // 定义当前的N叉树节点，保存临时值
        Node current = null;

        // 定义当前数组的值
        Integer value;

        // 定义队列，层序遍历创建N叉树
        Queue<Node> queue = new LinkedList<>();

        // 先把N叉树根节点放进队列最后
        queue.add(root);

        // 遍历数组，构造N叉树
        while (i < nums.length) {
            if (nums[i] == null) {
                // 若节点值为空，下标加1
                ++i;

                // 若节点值为空，队列出列元素，获取当前父节点
                current = queue.poll();
            } else {
                // 获取数组的值，数组下标加1
                value = nums[i++];

                // 创建当前父节点的孩子
                Node node = new Node(value);

                if (current == null) {
                    current = new Node();
                }

                if (current.children == null) {
                    current.children = new ArrayList<>();
                }

                // 当前父节点添加孩子
                current.children.add(node);

                // 把当前父节点的孩子入列
                queue.add(node);
            }
        }

        // 返回N叉树的根节点
        return root;
    }

    private static int maxDepth(Node root) {
        // 深度优先搜索，若一棵树有n个节点，设maxChildDepth为n个节点中的最大深度，那么这棵树的最大深度是n+1

        if (root == null) {
            // 若节点为空，返回0
            return 0;
        }

        // 定义最大子节点深度
        int maxChildDepth = 0;

        // 获取节点的子节点
        List<Node> children = root.children;

        if (children != null) {
            // 遍历子节点
            for (Node node : children) {
                // 递归调用自身，获取每一个子节点的最大深度
                int childDepth = maxDepth(node);

                // 和当前最大子节点深度比较，取最大值，更新到最大子节点深度
                maxChildDepth = Math.max(maxChildDepth, childDepth);
            }
        }

        // 返回最大子节点深度加1，即为n叉树的最大深度
        return maxChildDepth + 1;
    }

}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
