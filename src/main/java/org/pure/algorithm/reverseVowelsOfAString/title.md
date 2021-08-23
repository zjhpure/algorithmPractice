## 源码路径

/src/main/java/org/pure/algorithm/reverseVowelsOfAString/Main.java

## 题目地址(反转字符串中的元音字母)

https://leetcode-cn.com/problems/reverse-vowels-of-a-string

## 题目描述

```
给你一个字符串s，仅反转字符串中的所有元音字母，并返回结果字符串。

元音字母包括'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。

示例1:

输入：s = "hello"
输出："holle"

示例2:

输入：s = "leetcode"
输出："leotcede"

提示：

1 <= s.length <= 3 * 10^5
s由可打印的ASCII字符组成
```

## 代码

- 语言：Java

```
class Solution {

    // 方法1，虽然正确，但是繁杂混乱、理解困难，不推荐
    public String reverseVowels(String s) {
        // 使用双指针法，从字符串两侧往里遍历字符，如果两边对应出现元音字母，那么反转赋值到字符数组中，否则直接赋值到字符数组中

        if (s.length() == 1) {
            // 当字符串长度为1时，直接返回字符串
            return s;
        }

        // 定义反转后的字符数组，长度为字符串s的长度
        char[] cs = new char[s.length()];

        // 定义左侧是否找到元音字母的标识
        boolean isLeft = false;
        // 定义右侧是否找到元音字母的标识
        boolean isRight = false;

        // 定义左指针，初始为0
        int left = 0;
        // 定义右指针，初始为字符串s的最后下标
        int right = s.length() - 1;

        // 循环，当左指针大于等于右指针时，结束循环
        while (left < right) {
            if (isVowels(s.charAt(left))) {
                // 若左指针下标的字符是元音字母，标识标为true
                isLeft = true;
                if (isRight || left >= right) {
                    // 若右指针的标识也是true或者左指针等于右指针，那么右指针下标的字符赋值到字符数组的左指针下标的位置，左指针下标的字符赋值到字符数组的右指针下标的位置
                    cs[left] = s.charAt(right);
                    cs[right] = s.charAt(left);
                }
            } else {
                // 若左指针下标的字符不是元音字母，标识标为false，字符直接赋值给字符数组，左指针加1
                isLeft = false;
                cs[left] = s.charAt(left);
                ++left;
            }

            if (isVowels(s.charAt(right))) {
                // 若右指针下标的字符是元音字母，标识标为true
                isRight = true;
                if (isLeft || left >= right) {
                    // 若左指针的标识也是true或者左指针等于右指针，左指针下标的字符赋值到字符数组的右指针下标的位置，那么右指针下标的字符赋值到字符数组的左指针下标的位置
                    cs[right] = s.charAt(left);
                    cs[left] = s.charAt(right);
                }
            } else {
                // 若右指针下标的字符不是元音字母，标识标为false，字符直接赋值给字符数组，右指针减1
                isRight = false;
                cs[right] = s.charAt(right);
                --right;
            }

            // 重复判断一次左指针下标的字符是否是元音字母，因为可能是右指针下标的字符为元音字母，如果右指针下标的字符是元音字母，但是左指针下标的字符是否是元音字母的判断在前面，程序无法往回运行，所以这里再判断一次左指针下标的字符是否是元音字母
            if (isVowels(s.charAt(left))) {
                // 若左指针下标的字符是元音字母，标识标为true
                isLeft = true;
                if (isRight || left >= right) {
                    // 若右指针的标识也是true或者左指针等于右指针，那么右指针下标的字符赋值到字符数组的左指针下标的位置，左指针下标的字符赋值到字符数组的右指针下标的位置
                    cs[left] = s.charAt(right);
                    cs[right] = s.charAt(left);
                }
            } 

            if (isLeft && isRight) {
                // 若左指针和右指针的标识都为true，那么左指针和右指针的标识重置为false，同时左指针加1，右指针减1
                isLeft = false;
                isRight = false;
                ++left;
                --right;
            }

            if (left == right) {
                // 若左指针等于右指针，那么当前字符数组的下标进行一次直接赋值，因为如果当前下标的字母是元音字母而且只剩下一个时，如果不进行一次直接赋值，循环就结束了，这个下标的字符就会变成空值
                cs[left] = s.charAt(left);
            }
        }

        // 最后把字符数组转为字符串，返回结果
        return new String(cs);
    }

    // 判断当前字符是否为元音字母
    private boolean isVowels(char c) {
        return 'a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c || 'A' == c || 'E' == c || 'I' == c || 'O' == c || 'U' == c;
    }

}
```

```
class Solution {

    // 方法2，逻辑清晰，推荐
    public String reverseVowels(String s) {
        // 双指针法，从字符数组两侧往里遍历字符，直到出现元音字母或者超出字符数组边界，若在左指针小于右指针时出现两个元音字母，那么交换字符数组中的两个元音字母

        // 先把字符串转为字符数组
        char[] arr = s.toCharArray();

        // 定义左指针，从字符数组左侧开始，初始为0
        int left = 0;
        // 定义右指针，从字符数组右侧开始，初始为字符数组最后的下标
        int right = s.length() - 1;

        // 双指针往里遍历字符数组，循环直到左指针大于等于右指针
        while (left < right) {
            while (left < s.length() && isNotVowel(arr[left])) {
                // 若左指针还没超出字符数组边界并且指针位置的字符不是元音字母，那么左指针移动加1，直到左指针超出字符数组边界或指针位置的字符是元音字母，结束循环
                ++left;
            }

            while (right > 0 && isNotVowel(arr[right])) {
                // 若右指针还没超出字符数组边界并且指针位置的字符不是元音字母，那么右指针移动减1，直到右指针超出字符数组边界或指针位置的字符是元音字母，结束循环
                --right;
            }

            // 经过上面的两次while循环，要么出现左指针大于等于右指针，要么左右指针位置的字符都是元音字母

            if (left < right) {
                // 若左指针小于右指针，那么这时左右指针位置的字符都是元音字母，交换这两个元音字母
                swap(arr, left, right);
                // 左指针加1
                ++left;
                // 右指针减1
                --right;
            }
        }

        // 最后把字符数组转为字符串，返回结果
        return new String(arr);
    }

    // 判断当前字符是否不是元音字母
    private boolean isNotVowel(char c) {
        return 'a' != c && 'e' != c && 'i' != c && 'o' != c && 'u' != c && 'A' != c && 'E' != c && 'I' != c && 'O' != c && 'U' != c;
    }

    // 交换字符数组中的两个字符
    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
```