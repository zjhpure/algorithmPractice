package org.pure.algorithm.countItemsMatchingARule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-12 08:20
 * @description 统计匹配检索规则的物品数量
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String items = scanner.nextLine();
        String ruleKey = scanner.nextLine();
        String ruleValue = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strings = items.split("\\[\\[")[1].split("]]")[0].split("],\\[");
        List<List<String>> lists = new ArrayList<>();
        for (String string : strings) {
            List<String> list = new ArrayList<>();
            String[] strs = string.split(",");
            for (String str : strs) {
                list.add(str.split("\"")[1]);
            }
            lists.add(list);
        }

        // 获取输出结果
        int result = countMatches(lists, ruleKey, ruleValue);
        System.out.println(result);
    }

    private static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        // 定义匹配数量
        int nums = 0;

        // 遍历列表items
        for (List<String> item : items) {
            // 判断匹配类型
            if ("type".equals(ruleKey)) {
                // 若匹配类型是类型
                if (item.get(0).equals(ruleValue)) {
                    // 若类型值相等，匹配成功，匹配数量加1
                    ++nums;
                }
            } else if ("color".equals(ruleKey)) {
                // 若匹配类型是颜色
                if (item.get(1).equals(ruleValue)) {
                    // 若颜色值相等，匹配成功，匹配数量加1
                    ++nums;
                }
            } else if ("name".equals(ruleKey)) {
                // 若匹配类型是名称
                if (item.get(2).equals(ruleValue)) {
                    // 若名称值相等，匹配成功，匹配数量加1
                    ++nums;
                }
            }
        }

        return nums;
    }

}
