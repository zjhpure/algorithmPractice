## 源码路径

/src/main/java/org/pure/algorithm/constructBinaryTreeFromInAndPosTraversal/Main.java

## 题目地址(从中序与后序遍历序列构造二叉树)

https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

## 题目描述

```
给定一棵树的中序遍历inorder与后序遍历postorder。请构造二叉树并返回其根节点。

示例1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

示例2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]

注意:

你可以假设树中没有重复的元素
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
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
```