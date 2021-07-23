package org.pure.algorithm.addBinary;

import java.util.Scanner;
//import java.util.Stack;

/**
 * @author zhangjianhua
 * @date 2021-02-03 01:23
 * @description 二进制求和
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        String result = addBinary(a, b);
        System.out.println(result);
    }

//    // 思路：先转两个字符串为十进制，进行相加，再转回二进制
//    // 方法1，错误，因为在计算过程中会溢出，字符串的长度可能很长，而多一个长度就会指数级增长一个2的次方，在字符串转十进制时2的幂就已经溢出了
//    private static String addBinary(String a, String b) {
//        // 字符串a的十进制结果
//        int aInt = 0;
//
//        // 2的幂，初始为2^0
//        int twoPower = 1;
//
//        // 从0索引开始，倒着遍历字符串a，计算出字符串a的十进制结果
//        for (int i = 0; i < a.length(); ++i) {
//            // 获取字符
//            char c = a.charAt(a.length() - i - 1);
//
//            // 累加获取十进制结果
//            if (c == '1') {
//                // 若是1，就是1*2^n，也就是2^n
//                aInt += twoPower;
//            }
//            // 若是0，直接等于原值不变
//
//            // 获得下一个2的幂
//            twoPower = twoPower * 2;
//        }
//
//        // 字符串b的十进制结果
//        int bInt = 0;
//
//        // 2的幂重置为2^0
//        twoPower = 1;
//
//        // 从0索引开始，倒着遍历字符串b，计算出字符串b的十进制结果
//        for (int i = 0; i < b.length(); ++i) {
//            // 获取字符
//            char c = b.charAt(b.length() - i - 1);
//
//            // 累加获取十进制结果
//            if (c == '1') {
//                // 若是1，就是1*2^n，也就是2^n
//                bInt += twoPower;
//            }
//            // 若是0，直接等于原值不变
//
//            // 获得下一个2的幂
//            twoPower = twoPower * 2;
//        }
//
//        // 两个字符串转为十进制后直接相加获得它们的和
//        int result = aInt + bInt;
//
//        // 若它们的和是0，直接返回0
//        if (result == 0) {
//            return "0";
//        }
//
//        // 用除2取余法，先用栈保存倒序的数据，再从栈中推出数据，获取到顺序的数据
//
//        // 创建栈保存二进制结果
//        Stack<Integer> stack = new Stack<>();
//
//        // 十进制转为二进制
//        while (result > 0) {
//            // 取除以2的模
//            int rem = result % 2;
//
//            // 压入栈
//            stack.push(rem);
//
//            // 自身除以2
//            result = result / 2;
//        }
//
//        // 创建字符串builder保存二进制字符串结果
//        StringBuilder sb = new StringBuilder();
//
//        // 从栈推出数据，保存到字符串builder中
//        while (stack.size() > 0) {
//            // 推出元素
//            int s = stack.pop();
//
//            // 添加数据到字符串builder
//            if (s == 0) {
//                sb.append('0');
//            } else {
//                sb.append('1');
//            }
//        }
//
//        return sb.toString();
//    }

    // 思路：模拟竖式计算，从字符串的结尾遍历到字符串的开头，满2进1位
    // 方法2，可行
    private static String addBinary(String a, String b) {
        // 思路：模拟竖式计算，从字符串的结尾遍历到字符串的开头，满2进1位

        // 定义字符串集合sb，用来保存二进制求和后的结果
        StringBuilder sb = new StringBuilder();

        // 取字符串a和字符串b中较长的长度
        int length = Math.max(a.length(), b.length());

        // 定义进位，初始为0
        int carry = 0;

        // 从0遍历到字符串中的最大下标，取字符时从字符串结尾开始取
        for (int i = 0; i < length; ++i) {
            if (i < a.length()) {
                // 若当前下标还在字符串a中，取字符串a倒数第i+1个字符，通过减去0的ASCII码得到当前数字，当前数字只会是0或1，把当前数字累加到进位carry里
                carry += a.charAt(a.length() - 1 - i) - '0';
            }

            if (i < b.length()) {
                // 若当前下标还在字符串b中，取字符串b倒数第i+1个字符，通过减去0的ASCII码得到当前数字，当前数字只会是0或1，把当前数字累加到进位carry里
                carry += b.charAt(b.length() - 1 - i) - '0';
            }

            // 获取进位carry除以2的余数，再把数字加上0的ASCII得到余数的ASCII码，再强转为char类型，这里得到结果只会是0或1，因为carry是两个字符串同一个位上相加的结果，只可能是0、1、2、3其中一个，对于二进制取余就是对2取余，对于十进制取余就是对10取余，例如11取余就是1，向前进1位，对于二进制，例如2取余就是0，向前进1位
            sb.append((char) (carry % 2 + '0'));

            // 进位除以2，得到进位的数，此数在下一对竖式相加时会用到，正好模拟了竖式计算中的进位计算
            carry /= 2;
        }

        if (carry > 0) {
            // 如果前面还有进位的数，那么需要补充1，例如：11 + 10 = 101，前面的for循环只计算了出了01的反转10，但是在计算最后的位时是1+1=2，向前进1位，carry除以2等于1，得到进位的数，这时还需要补充一个1来填补进位，得到101，反转后就是101
            sb.append('1');
        }

        // 因为是从字符串的末尾开始计算的，所以得到的字符串集合sb是反转过来的，这里把sb再反转一次，得到原来的结果
        sb.reverse();

        // 字符串集合sb转为字符串返回
        return sb.toString();
    }

}
