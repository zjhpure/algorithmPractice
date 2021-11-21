## 源码路径

/src/main/java/org/pure/algorithm/maximumDepthOfNAryTree/Main.java

## 题目地址(N叉树的最大深度)

https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree

## 题目描述

```
给定一个N叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

N叉树输入按层序遍历序列化表示，每组子节点由空值分隔(请参见示例)。

示例1：

输入：root = [1,null,3,2,4,null,5,6]
输出：3

示例2：

输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：5

提示：

树的深度不会超过1000。
树的节点数目位于[0, 10^4]之间。
```

## 代码

- 语言：Java

```
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    public int maxDepth(Node root) {
        // 深度优先搜索，若一棵树有n个节点，设maxChildDepth为n个节点中的最大深度，那么这棵树的最大深度是n+1

        if (root == null) {
            // 若节点为空，返回0
            return 0;
        }

        // 定义最大子节点深度
        int maxChildDepth = 0;

        // 获取节点的子节点
        List<Node> children = root.children;

        if (children != null) {
            // 遍历子节点
            for (Node node : children) {
                // 递归调用自身，获取每一个子节点的最大深度
                int childDepth = maxDepth(node);

                // 和当前最大子节点深度比较，取最大值，更新到最大子节点深度
                maxChildDepth = Math.max(maxChildDepth, childDepth);
            }
        }

        // 返回最大子节点深度加1，即为n叉树的最大深度
        return maxChildDepth + 1;
    }

}
```