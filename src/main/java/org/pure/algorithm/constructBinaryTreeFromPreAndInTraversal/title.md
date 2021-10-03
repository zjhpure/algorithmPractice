## 源码路径

/src/main/java/org/pure/algorithm/constructBinaryTreeFromPreAndInTraversal/Main.java

## 题目地址(从前序与中序遍历序列构造二叉树)

https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

## 题目描述

```
给定一棵树的前序遍历preorder与中序遍历inorder。请构造二叉树并返回其根节点。

示例1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

示例2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]

提示:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder和inorder均无重复元素
inorder均出现在preorder
preorder保证为二叉树的前序遍历序列
inorder保证为二叉树的中序遍历序列
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

    // 定义哈希表，方便快速定位根节点
    private Map<Integer, Integer> indexMap = new HashMap<>();

    // 构建树
    private TreeNode myBuildTree(int[] preorder, int preorderLeft, int preorderRight, int inorderLeft) {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
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
```