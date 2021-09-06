## 源码路径

/src/main/java/org/pure/algorithm/binaryTreeInorderTraversal/Main.java

## 题目地址(二叉树的中序遍历)

https://leetcode-cn.com/problems/binary-tree-inorder-traversal

## 题目描述

```
给定一个二叉树的根节点root，返回它的中序遍历。

示例1:

输入：root = [1,null,2,3]
输出：[1,3,2]

示例2：

输入：root = []
输出：[]

示例3：

输入：root = [1]
输出：[1]

示例4：

输入：root = [1,2]
输出：[2,1]

示例5：

输入：root = [1,null,2]
输出：[1,2]

提示：

树中节点数目在范围[0, 100]内
-100 <= Node.val <= 100

进阶：
递归算法很简单，你可以通过迭代算法完成吗？
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // 中序遍历二叉树
        inTraversal(list, root);

        return list;
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