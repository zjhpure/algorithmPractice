## 源码路径

/src/main/java/org/pure/algorithm/searchInABinarySearchTree/Main.java

## 题目地址(二叉搜索树中的搜索)

https://leetcode-cn.com/problems/search-in-a-binary-search-tree

## 题目描述

```
给定二叉搜索树(BST)的根节点和一个值。你需要在BST中找到节点值等于给定值的节点。返回以该节点为根的子树。如果节点不存在，则返回NULL。

例如，

给定二叉搜索树：

        4
       / \
      2   7
     / \
    1   3

和值: 2
你应该返回如下子树：

      2     
     / \   
    1   3
在上述示例中，如果要找的值是5，但因为没有节点值为5，我们应该返回NULL。
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

    private TreeNode node;

    public TreeNode searchBST(TreeNode root, int val) {
        // 深度优先搜索
        
        recursive(root, val);

        return node;
    }

    // 递归查找二叉树
    private void recursive(TreeNode root, int val) {
        if (root == null) {
            return;
        }

        // 搜索左子树
        recursive(root.left, val);

        if (root.val == val) {
            // 若值和当前节点的值相等，那么找到了节点
            node = root;
            return;
        }

        // 搜索右子树
        recursive(root.right, val);
    }

}
```