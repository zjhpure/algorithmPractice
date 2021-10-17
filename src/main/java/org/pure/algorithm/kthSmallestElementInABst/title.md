## 源码路径

/src/main/java/org/pure/algorithm/kthSmallestElementInABst/Main.java

## 题目地址(二叉搜索树中第K小的元素)

https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst

## 题目描述

```
给定一个二叉搜索树的根节点root，和一个整数k，请你设计一个算法查找其中第k个最小元素(从1开始计数)。

示例1:

输入：root = [3,1,4,null,2], k = 1
输出：1

示例2：

输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3

提示：

树中的节点数为n。
1 <= k <= n <= 10^4
0 <= Node.val <= 10^4

进阶：

如果二叉搜索树经常被修改(插入/删除操作)并且你需要频繁地查找第k小的值，你将如何优化算法？
```

## 代码

- 语言：Java

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历法，取第k个元素，因为是二叉搜索树，所以中序遍历得到的是有序的元素

        // 定义列表，保存排好序的元素
        List<Integer> list = new ArrayList<>();

        // 中序遍历二叉树
        inTraversal(list, root);

        // 获取从小排到大的列表，返回第k个元素
        return list.get(k - 1);
    }

    // 中序遍历二叉树，递归法
    private void inTraversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        // 处理左节点
        inTraversal(list, root.left);

        // 根节点添加到列表中
        list.add(root.val);

        // 处理右节点
        inTraversal(list, root.right);
    }

}
```