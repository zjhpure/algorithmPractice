## 源码路径

/src/main/java/org/pure/algorithm/binaryTreeTilt/Main.java

## 题目地址(二叉树的坡度)

https://leetcode-cn.com/problems/binary-tree-tilt

## 题目描述

```
给定一个二叉树，计算整个树的坡度 。

一个树的节点的坡度定义即为，该节点左子树的节点之和和右子树节点之和的差的绝对值。如果没有左子树的话，左子树的节点之和为0；没有右子树的话也是一样。空结点的坡度是0。

整个树的坡度就是其所有节点的坡度之和。

示例1：

输入：root = [1,2,3]
输出：1
解释：
节点2的坡度：|0-0| = 0（没有子节点）
节点3的坡度：|0-0| = 0（没有子节点）
节点1的坡度：|2-3| = 1（左子树就是左子节点，所以和是2；右子树就是右子节点，所以和是3）
坡度总和：0 + 0 + 1 = 1

示例2：

输入：root = [4,2,9,3,5,null,7]
输出：15
解释：
节点3的坡度：|0-0| = 0（没有子节点）
节点5的坡度：|0-0| = 0（没有子节点）
节点7的坡度：|0-0| = 0（没有子节点）
节点2的坡度：|3-5| = 2（左子树就是左子节点，所以和是3；右子树就是右子节点，所以和是5）
节点9的坡度：|0-7| = 7（没有左子树，所以和是0；右子树正好是右子节点，所以和是7）
节点4的坡度：|(3+5+2)-(9+7)| = |10-16| = 6（左子树值为3、5和2，和是10 ；右子树值为9和7，和是16）
坡度总和：0 + 0 + 0 + 2 + 7 + 6 = 15

示例3：

输入：root = [21,7,14,1,1,2,2,3,3]
输出：9

提示：

树中节点数目的范围在[0, 104]内
-1000 <= Node.val <= 1000
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

    // 模拟法
    
    // 定义坡度之和
    private int sum = 0;
    // 定义左子树节点之和
    private int leftSum = 0;
    // 定义右子树节点之和
    private int rightSum = 0;

    public int findTilt(TreeNode root) {
        // 递归遍历二叉树，计算整个二叉树的坡度之和
        traversal(root);

        // 返回坡度之和
        return sum;
    }

    // 通过递归遍历二叉树，计算每一个节点的坡度
    private void traversal(TreeNode root) {
        if (root == null) {
            // 当节点为空时，跳出递归
            return;
        }

        // 左子树节点之和归零
        leftSum = 0;
        // 右子树节点之和归零
        rightSum = 0;

        // 获取左子树的节点之和
        getSum(root.left, true);
        // 获取右子树的节点之和
        getSum(root.right, false);

        // 计算左子树的节点之和和右子树的节点之和的差的绝对值
        sum += Math.abs(leftSum - rightSum);

        // 跳到当前节点的左子树
        traversal(root.left);
        // 跳到当前节点的右子树
        traversal(root.right);
    }

    // 获取当前节点之和
    private void getSum(TreeNode node, boolean isLeft) {
        if (node == null) {
            // 当节点为空时，跳出递归
            return;
        }

        if (isLeft) {
            // 计算左节点
            leftSum += node.val;
        } else {
            // 计算右节点
            rightSum += node.val;
        }

        // 计算当前节点的左子树
        getSum(node.left, isLeft);
        // 计算当前节点的右子树
        getSum(node.right, isLeft);
    }

}
```