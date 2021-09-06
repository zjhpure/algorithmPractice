## 源码路径

/src/main/java/org/pure/algorithm/binaryTreePreorderTraversal/Main.java

## 题目地址(二叉树的前序遍历)

https://leetcode-cn.com/problems/binary-tree-preorder-traversal

## 题目描述

```
给你二叉树的根节点root，返回它节点值的前序遍历。

示例1:

输入：root = [1,null,2,3]
输出：[1,2,3]

示例2：

输入：root = []
输出：[]

示例3：

输入：root = [1]
输出：[1]

示例4：

输入：root = [1,2]
输出：[1,2]

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

    public List<Integer> preorderTraversal(TreeNode root) {
        // 迭代法，使用栈辅助

        // 定义列表，保存二叉树前序遍历的结果
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            // 若二叉树为空，直接返回空列表
            return list;
        }
        
        // 定义栈
        Stack<TreeNode> stack = new Stack<>();

        // 先把根节点入栈
        stack.push(root);

        // 当栈为空时，结束循环
        while (!stack.isEmpty()) {
            // 出栈
            TreeNode node = stack.pop();

            // 处理根节点，保存数据到列表中
            list.add(node.val);

            // 因为栈是先入后出，而前序遍历先左节点后右节点，所以这里先处理右节点，再处理左节点

            if (node.right != null) {
                // 处理右节点，若不为空，入栈
                stack.push(node.right);
            }

            if (node.left != null) {
                // 处理左节点，若不为空，入栈
                stack.push(node.left);
            }
        }

        // 返回列表
        return list;
    }

}
```