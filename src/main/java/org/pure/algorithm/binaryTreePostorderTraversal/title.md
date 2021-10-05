## 源码路径

/src/main/java/org/pure/algorithm/binaryTreePostorderTraversal/Main.java

## 题目地址(二叉树的后序遍历)

https://leetcode-cn.com/problems/binary-tree-postorder-traversal

## 题目描述

```
给定一个二叉树，返回它的后序遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3 

输出: [3,2,1]

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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // 后序遍历二叉树
        postTraversal(list, root);

        return list;
    }

    // 后序遍历二叉树，递归法
    private void postTraversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        // 处理左节点
        postTraversal(list, root.left);
        // 处理右节点
        postTraversal(list, root.right);
        // 根节点添加到列表中
        list.add(root.val);
    }

}
```

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

    public List<Integer> postorderTraversal(TreeNode root) {
        // 迭代法，使用栈辅助

        // 定义列表，保存二叉树的中序遍历的结果
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            // 若二叉树为空，直接返回空列表
            return list;
        }

        // 定义栈
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;

        // 当栈为空时，结束循环
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }

        // 返回列表
        return list;
    }

}
```