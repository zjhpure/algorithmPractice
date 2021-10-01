## 源码路径

/src/main/java/org/pure/algorithm/sameTree/Main.java

## 题目地址(相同的树)

https://leetcode-cn.com/problems/same-tree

## 题目描述

```
给你两棵二叉树的根节点p和q，编写一个函数来检验这两棵树是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例1:

输入：p = [1,2,3], q = [1,2,3]
输出：true

示例2:

输入：p = [1,2], q = [1,null,2]
输出：false

示例3:

输入：p = [1,2,1], q = [1,1,2]
输出：false

提示：

两棵树上的节点数目都在范围[0, 100]内
-10^4 <= Node.val <= 10^4
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 通过深度优先搜索，逐个比较节点值和树结构

        if (p == null && q == null) {
            // 若两个节点都为空，那么节点值和树结构都相同，所以树相同
            return true;
        } else if (p == null || q == null) {
            // 若两个节点中只有一个不为空，那么树结构不相同，所以树不相同
            return false;
        } else if (p.val != q.val){
            // 若上面三种情况都不是，那么就是两个节点都不为空，这时候判断节点值是否相等，若两个节点值不相等，那么树不相同
            return false;
        } else {
            // 若上面的情况都不出现，那么就是节点值和树结构都相同，并且节点都不为空，所以判断节点的左子树和右子树是否都满足条件，递归调用同样的方法，进行同样的判断
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}
```