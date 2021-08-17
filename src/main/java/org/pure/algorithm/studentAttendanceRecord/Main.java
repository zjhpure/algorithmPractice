package org.pure.algorithm.studentAttendanceRecord;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-08-17 23:33
 * @description 学生出勤记录I
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        boolean result = checkRecord(str);
        System.out.println(result);
    }

    private static boolean checkRecord(String s) {
        // 定义统计天数，先用作统计缺勤总天数
        int count = 0;

        // 第一次遍历字符串s的字符，判断缺勤总天数是否小于2
        for (int i = 0; i < s.length(); ++i) {
            if ('A' == s.charAt(i)) {
                // 若出现缺勤，那么缺勤总天数加1
                ++count;

                // 若缺勤总天数大于等于2，那么不符合条件，马上返回false
                if (count >= 2) {
                    return false;
                }
            }
        }

        // count用作统计连续迟到天数，重新置为0
        count = 0;

        // 第二次遍历字符串s的字符，
        for (int i = 0; i < s.length(); ++i) {
            if ('L' == s.charAt(i)) {
                if (i == 0) {
                    // 若迟到出现在第一个字符，那么连续迟到天数直接加1
                    ++count;
                } else if ('L' == s.charAt(i - 1)) {
                    // 若迟到出现在第二个字符之后并且前一个字符也是迟到，那么连续迟到天数加1
                    ++count;

                    // 若连续迟到天数大于等于3，那么不符合条件，马上返回false
                    if (count >= 3) {
                        return false;
                    }
                } else {
                    // 若前一个字符不是迟到，那么连续迟到天数设置为1
                    count = 1;
                }
            } else {
                // 若不出现迟到，那么连续迟到天数归零
                count = 0;
            }
        }

        // 若程序能运行到这里，那么缺勤条件和迟到条件都达到，符合条件，返回true
        return true;
    }

}
