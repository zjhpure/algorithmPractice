## 源码路径

/src/main/java/org/pure/algorithm/allElementsInTwoBinarySearchTrees/Main.java

## 题目地址(两棵二叉搜索树中的所有元素)

https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees

## 题目描述

```
给你root1和root2这两棵二叉搜索树。

请你返回一个列表，其中包含两棵树中的所有整数并按升序排序。

示例1:

输入：root1 = [2,1,4], root2 = [1,0,3]
输出：[0,1,1,2,3,4]

示例2：

输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
输出：[-10,0,0,1,2,5,7,10]

示例3：

输入：root1 = [], root2 = [5,1,7,0,2]
输出：[0,1,2,5,7]

示例4：

输入：root1 = [0,-10,10], root2 = []
输出：[-10,0,10]

示例5：

输入：root1 = [1,null,8], root2 = [8,1]
输出：[1,1,8,8]

提示：

每棵树最多有5000个节点。
每个节点的值在[-10^5, 10^5]之间。
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

    // 定义列表，用来保存结果
    private List<Integer> list = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // 前序遍历第一棵二叉搜索树
        inOrder(root1);
        // 前序遍历第二棵二叉搜索树
        inOrder(root2);
        // 对列表排序
        Collections.sort(list);
        // 返回排序好的列表
        return list;
    }

    // 前序遍历
    private void inOrder(TreeNode root) {
        if (root == null) {
            // 若节点为空，返回结束
            return;
        }

        // 添加节点的值到列表中
        list.add(root.val);
        // 前序遍历左节点
        inOrder(root.left);
        // 前序遍历右节点
        inOrder(root.right);
    }

}
```