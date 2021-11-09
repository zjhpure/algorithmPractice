## 源码路径

/src/main/java/org/pure/algorithm/zumaGame/Main.java

## 题目地址(祖玛游戏)

https://leetcode-cn.com/problems/zuma-game

## 题目描述

```
你正在参与祖玛游戏的一个变种。

在这个祖玛游戏变体中，桌面上有一排彩球，每个球的颜色可能是：红色'R'、黄色'Y'、蓝色'B'、绿色'G'或白色'W'。你的手中也有一些彩球。

你的目标是清空桌面上所有的球。每一回合：

从你手上的彩球中选出任意一颗，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。
接着，如果有出现三个或者三个以上且颜色相同的球相连的话，就把它们移除掉。
如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。
如果桌面上所有球都被移除，则认为你赢得本场游戏。
重复这个过程，直到你赢了游戏或者手中没有更多的球。
给你一个字符串board，表示桌面上最开始的那排球。另给你一个字符串hand，表示手里的彩球。请你按上述操作步骤移除掉桌上所有球，计算并返回所需的最少球数。如果不能移除桌上所有的球，返回-1。

示例1：

输入：board = "WRRBBW", hand = "RB"
输出：-1
解释：无法移除桌面上的所有球。可以得到的最好局面是：
- 插入一个'R'，使桌面变为WRRRBBW。WRRRBBW -> WBBW
- 插入一个'B'，使桌面变为WBBBW。WBBBW -> WW
桌面上还剩着球，没有其他球可以插入。

示例2：

输入：board = "WWRRBBWW", hand = "WRBRW"
输出：2
解释：要想清空桌面上的球，可以按下述步骤：
- 插入一个'R'，使桌面变为WWRRRBBWW。WWRRRBBWW -> WWBBWW
- 插入一个'B'，使桌面变为WWBBBWW。WWBBBWW -> WWWW -> empty
只需从手中出2个球就可以清空桌面。

示例3：

输入：board = "G", hand = "GGGGG"
输出：2
解释：要想清空桌面上的球，可以按下述步骤：
- 插入一个'G'，使桌面变为GG。
- 插入一个'G'，使桌面变为GGG。GGG -> empty
只需从手中出2个球就可以清空桌面。

示例4：

输入：board = "RBYYBBRRB", hand = "YRBGB"
输出：3
解释：要想清空桌面上的球，可以按下述步骤：
- 插入一个'Y'，使桌面变为RBYYYBBRRB。RBYYYBBRRB -> RBBBRRB -> RRRB -> B
- 插入一个'B'，使桌面变为BB。
- 插入一个'B'，使桌面变为BBB。BBB -> empty
只需从手中出3个球就可以清空桌面。

提示：

1 <= board.length <= 16
1 <= hand.length <= 5
board和hand由字符'R'、'Y'、'B'、'G'和'W'组成
桌面上一开始的球中，不会有三个及三个以上颜色相同且连着的球
```

## 代码

- 语言：Java

```
class Solution {

    // 最大范围
    private int ans = Integer.MAX_VALUE;

    // 剪枝用
    private HashSet<String> cache = new HashSet<>();

    // 手里球的个数
    private int count;

    public int findMinStep(String board, String hand) {
        // 暴力法，待理解原理

        count = hand.length();

        int[] hands = new int[5];

        // 统计每个球的个数
        for (int i = 0; i < hand.length(); i++) {
            hands[getId(hand.charAt(i))]++;
        }

        // 深度优先搜索
        dfs(board, hands, 0);

        // 返回结果
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // 深度优先搜索
    private void dfs(String board, int[] hands, int step) {
        // 消消乐
        board = xiaoxiaole(board);

        // 如果全部消除了
        if (board.length() == 0) {
            ans = Math.min(ans, step);
            return;
        }

        // 如果手上的球用完了
        if (step == count) {
            return;
        }

        // 步数大于等于以前找到的ans,就直接剪枝
        if (step >= ans) {
            return;
        }

        // 用String方式固定状态放入缓存中
        String node = board + Arrays.toString(hands);

        // 如果有相同状态,直接剪枝
        if (cache.contains(node)) {
            return;
        }

        for (int i = 0; i < hands.length; i++) {
            if (hands[i] == 0) {
                continue;
            }

            // 挑选hand，进行下一层dfs
            hands[i]--;

            for (int j = 0; j < board.length(); j++) {
                // 枚举当前球应该放的位置
                dfs(board.substring(0, j) + getChar(i) + board.substring(j), hands, step + 1);
            }

            // 进行回溯
            hands[i]++;
        }

        cache.add(node);
    }

    // 消消乐代码，三个一样就消除
    private String xiaoxiaole(String board) {
        int s = 0;

        int length = board.length();

        for (int i = 1; i <= length; i++) {
            // 有可能最后几个字母就是相同的，这样就会来到i == length
            if (i == length || board.charAt(i) != board.charAt(i - 1)) {
                // 只有字符不连续才会进入if，当前s下标是连续字符串的第一个
                // i下标是不连续字符串的第一个
                if (i - s >= 3) {
                    return xiaoxiaole(board.substring(0, s) + board.substring(i));
                } else {
                    // 更新s下标
                    s = i;
                }
            }
        }

        return board;
    }

    // 解析那种颜色球的下标
    private static int getId(char c) {
        if (c == 'W') {
            return 0;
        } else if (c == 'B') {
            return 1;
        } else if (c == 'Y') {
            return 2;
        } else if (c == 'G') {
            return 3;
        } else {
            return 4;
        }
    }

    // 获取球的颜色
    private char getChar(int id) {
        if (id == 0) {
            return 'W';
        } else if (id == 1) {
            return 'B';
        } else if (id == 2) {
            return 'Y';
        } else if (id == 3) {
            return 'G';
        } else {
            return 'R';
        }
    }

}
```