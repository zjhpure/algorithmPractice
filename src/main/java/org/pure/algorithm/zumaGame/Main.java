package org.pure.algorithm.zumaGame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-09 23:14
 * @description 祖玛游戏
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String board = scanner.nextLine();
        String hand = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int result = findMinStep(board, hand);
        System.out.println(result);
    }

    // 最大范围
    private static int ans = Integer.MAX_VALUE;

    // 剪枝用
    private static HashSet<String> cache = new HashSet<>();

    // 手里球的个数
    private static int count;

    private static int findMinStep(String board, String hand) {
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
    private static void dfs(String board, int[] hands, int step) {
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
    private static String xiaoxiaole(String board) {
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
    private static char getChar(int id) {
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
