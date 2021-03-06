package org.pure.algorithm.findMajorityElement;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-09 13:40
 * @description 主要元素
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = majorityElement(nums);
        System.out.println(result);
    }

    private static int majorityElement(int[] nums) {
        // 利用摩尔投票算法，统计数量最多的元素
        // 遍历数组，当统计数量为0时，把当前元素假定为数量最多的元素，统计数量加1，后面继续遍历，如果后面的元素和当前元素相等，统计数量继续加1，如果不相等，统计数量减1，等于说相互抵消掉，这个元素有1个，那个元素有1个，那么他们数量相等，而这里是要统计数量最多的元素，所以他们就两两抵消，后面继续遍历，如果统计数量又变回0了，继续上面的操作，直到遍历数组结束，最后如果统计数量为0，那么没有数量最多的元素(这里不包括数量重复的元素)，因为全部被两两抵消了，如果统计数量大于0，那么找到了数量最多的元素

        // 定义找到的元素
        int find = -1;
        // 定义找到元素的数量
        int count = 0;

        // 遍历数组nums，找出数量最多的元素
        for (int num : nums) {
            if (count == 0) {
                // 若数量为0，找到的元素设置为当前元素
                find = num;
            }

            if (num == find) {
                // 若当前元素和找到的元素相等，数量加1
                ++count;
            } else {
                // 若当前元素和找到的元素不相等，数量减1
                --count;
            }
        }

        // 至此找到了数量最多的元素，若数量count等于0，没有数量最多的元素(这里不包括数量重复的元素)，这里找到的元素是最后被两两抵消掉的元素的第一个，但是不可能出现主要元素存在前面的情况，因为主要元素是指数量占比超过一半的元素，如果前面存在主要元素，后面是不可能有被两两抵消掉的，因为主要元素已经占了超过一半，后面的数量不够一半了，所以前面的元素肯定是被两两抵消掉了，那么由此就推出前面不存在主要元素；若数量count大于0，找到数量最多的元素

        // 找到元素的数量重置为0
        count = 0;

        // 遍历数组nums，统计数量最多的元素的数量
        for (int num : nums) {
            if (num == find) {
                ++count;
            }
        }

        // 若找到元素的数量超过一半，那么就是主要元素，返回找到的元素find，否则就是没有主要元素，返回-1
        return count * 2 > nums.length ? find : -1;
    }

}
