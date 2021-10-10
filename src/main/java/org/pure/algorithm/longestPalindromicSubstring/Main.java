package org.pure.algorithm.longestPalindromicSubstring;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-13 22:13
 * @description 最长回文子串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();

        // 获取输出结果
        String result = longestPalindrome(s);
        System.out.println(result);
    }

//    // 方法1，三个for循环，超出时间限制，不建议使用
//    private static String longestPalindrome(String s) {
//        if (s.length() == 1) {
//            // 若字符串s为单个字符，直接返回本身
//            return s;
//        }
//
//        // 最长回文子串
//        String maxStr = "";
//
//        // 回文子串最大长度
//        int maxSize = 1;
//
//        // 遍历字符串s
//        for (int i = 0; i < s.length(); ++i) {
//            for (int j = i + 1; j < s.length(); ++j) {
//                // 构造子串
//                String str = s.substring(i, j + 1);
//
//                // 是否为回文串
//                boolean isPalindrome = true;
//
//                // 获取字串长度
//                int length = str.length();
//
//                // 遍历字串字符到一半
//                for (int n = 0; n < length / 2; ++n) {
//                    // 当前字符
//                    char a = str.charAt(n);
//
//                    // 交叉位置的字符
//                    char b = str.charAt(length - n - 1);
//
//                    if (a != b) {
//                        // 若两个字符不等，则字串不是回文串
//                        isPalindrome = false;
//                        break;
//                    }
//                }
//
//                // 判断字符串是否为回文串
//                if (isPalindrome) {
//                    // 获取回文子串长度
//                    int size = j - i + 1;
//
//                    if (size > maxSize) {
//                        // 更新回文子串最大长度
//                        maxSize = size;
//                        // 更新最长回文子串
//                        maxStr = str;
//                    }
//                }
//            }
//        }
//
//        if (maxSize == 1) {
//            // 若回文子串最大长度还是1，那么回文子串就是一个字符，则取第1个字符
//            maxStr = s.substring(0, 1);
//        }
//
//        return maxStr;
//    }

    // 方法2，动态规划法
    private static String longestPalindrome(String s) {
        // 动态规划法，用i和j分别表示子串的起始下标和结束下标，两边都是闭合区间，那么状态转移方程：dp[i][j] = (s[i] == s[j]) and (j - i < 3 or dp[i + 1][j - 1])，即如果要判断一个子串是回文子串，那么就等同于判断起始下标i的字符是否等于结束下标j的字符，以及判断起始下标i和结束下标j相减的差是否小于3或者这个子串前后各自往回一个的字符串是否为回文子串，这里关键就是可以通过较短的子串来判断较长的子串是否为回文子串，即可以用前面的结果来判断后面的结果
        // 可以想象成一个boolean类型的二维数组，长和宽都是字符串s的长度，宽用i，代表回文子串的起始下标，长用j，代表回文子串的结束下标，这个二维数组的对角线，即起始下标的字符和结束下标的字符相等，肯定是回文子串，所以i==j的地方可以先填上true，再通过状态转移方程：dp[i][j] = (s[i] == s[j]) and (j - i < 3 or dp[i + 1][j - 1])，可以推导出其他位置的值，其实二维数组只需要填入一半即可，对角线往一个方向的数据填上即可，因为另一个方向的数据是一样的，例如：[1,3]和[3,1]是一样的，严格来说[3,1]不合法，因为结束下标必须大于等于起始下标，所以实际上二维数组只需要填上一半的数据

        // 获取字符串s的长度
        int len = s.length();

        if (len < 2) {
            // 若字符串s的长度小于2，那么自身就是最长回文子串
            return s;
        }

        // 定义最长回文子串的长度，初始为1
        int maxLen = 1;
        // 定义最长回文子串的起始下标，初始为0
        int begin = 0;

        // dp[i][j]表示s[i..j]是否是回文串
        boolean[][] dp = new boolean[len][len];

        // 初始化二维数组，把能马上判断出来都先填上，所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            // 所有对角线的数据都是回文串
            dp[i][i] = true;
        }

        // 把字符串s转为字符数组
        char[] charArray = s.toCharArray();

        // 递推开始，一列一列来，先枚举结束下标j，从1开始，因为[0,0]在前面已经确定了下来
        for (int j = 1; j < len; ++j) {
            // 再枚举起始下标i，起始下标小于结束下标
            for (int i = 0; i < j; ++i) {
                if (charArray[i] != charArray[j]) {
                    // 若起始下标i的字符不等于结束下标j的字符，那么这个子串不是回文子串
                    dp[i][j] = false;
                } else {
                    // 若起始下标i的字符等于结束下标j的字符，进行进一步的判断
                    if (j - i < 3) {
                        // 若起始下标i和结束下标j相减的差小于3，即他们相隔小于2，即他们之间只有一个字符或者没有字符，那么这个子串是回文子串
                        dp[i][j] = true;
                    } else {
                        // 若起始下标i和结束下标j相减的差大于等于3，那么这个子串是否为回文子串就由这个子串前后各自往回一个的字符串是否为回文子串决定，若各自往回一个的字符串是回文子串，那么这个子串也是回文子串，否则这个子串就不是回文子串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要dp[i][j]为true，就表示子串s[i..j]是回文子串，更新回文子串的起始下标和长度
                if (dp[i][j] && j - i + 1 > maxLen) {
                    // 更新回文子串的长度
                    begin = i;
                    // 更新回文子串的长度
                    maxLen = j - i + 1;
                }
            }
        }

        // 字符串s从起始下标开始，截取最大长度maxLen，就是最长回文子串
        return s.substring(begin, begin + maxLen);
    }

}
