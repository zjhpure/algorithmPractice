## 源码路径

/src/main/java/org/pure/algorithm/invertBinaryTree/Main.java

## 题目地址(翻转二叉树)

https://leetcode-cn.com/problems/invert-binary-tree

## 题目描述

```
翻转一棵二叉树。

示例:

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

备注：

这个问题是受到Max Howell的原问题启发的：

谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
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

    public TreeNode invertTree(TreeNode root) {
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
```