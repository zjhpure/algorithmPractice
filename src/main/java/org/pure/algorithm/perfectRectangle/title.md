## 源码路径

/src/main/java/org/pure/algorithm/perfectRectangle/Main.java

## 题目地址(完美矩形)

https://leetcode-cn.com/problems/perfect-rectangle

## 题目描述

```
给你一个数组rectangles，其中rectangles[i] = [xi, yi, ai, bi]表示一个坐标轴平行的矩形。这个矩形的左下顶点是(xi, yi)，右上顶点是(ai, bi)。

如果所有矩形一起精确覆盖了某个矩形区域，则返回true；否则，返回false。

示例1：

输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
输出：true
解释：5个矩形一起可以精确地覆盖一个矩形区域。

示例2：

输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
输出：false
解释：两个矩形之间有间隔，无法覆盖成一个矩形。

示例3：

输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
输出：false
解释：图形顶端留有空缺，无法覆盖成一个矩形。

示例4：

输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
输出：false
解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。

提示：

1 <= rectangles.length <= 2 * 10^4
rectangles[i].length == 4
-10^5 <= xi, yi, ai, bi <= 10^5
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isRectangleCover(int[][] rectangles) {
        // 条件1：计算小矩形面积之和，计算大矩形面积，判断小矩形面积之和是否等于大矩形面积
        // 条件2：最左下、最左上、最右下、最右上的四个点只出现一次，其他点成对出现，即只出现2次或者4次

        // 小矩形面积之和
        int sum = 0;

        // 最左下横坐标
        int minX = rectangles[0][0];
        // 最左下纵坐标
        int minY = rectangles[0][1];
        // 最右上横坐标
        int maxX = rectangles[0][2];
        // 最右上纵坐标
        int maxY = rectangles[0][3];

        // 遍历小矩形
        for (int[] rectangle : rectangles) {
            // 小矩形长度
            int length = rectangle[2] - rectangle[0];
            // 小矩形宽度
            int width = rectangle[3] - rectangle[1];

            // 累加计算小矩形面积之和
            sum += length * width;

            if (rectangle[0] <= minX && rectangle[1] <= minY) {
                // 更新最左下横坐标
                minX = rectangle[0];
                // 更新最左下纵坐标
                minY = rectangle[1];
            }

            if (rectangle[2] >= maxX && rectangle[3] >= maxY) {
                // 更新最右上横坐标
                maxX = rectangle[2];
                // 更新最右上纵坐标
                maxY = rectangle[3];
            }
        }

        // 计算大矩形面积
        int area = (maxX - minX) * (maxY - minY);

        if (sum == area) {
            // 若小矩形面积之和等于大矩形面积，判断最左下、最左上、最右下、最右上的四个点是否只出现一次

            // 最左下坐标数量
            int leftBottomCount = 0;
            // 最左上坐标数量
            int leftTopCount = 0;
            // 最右下坐标数量
            int rightBottomCount = 0;
            // 最右上坐标数量
            int rightTopCount = 0;

            // 定义集合，保存非最顶点坐标的数量
            Map<String, Integer> map = new HashMap<>();

            // 再次遍历小矩形
            for (int[] rectangle : rectangles) {
                if (rectangle[0] == minX && rectangle[1] == minY) {
                    // 最左下坐标数量加1
                    ++leftBottomCount;
                    if (leftBottomCount > 1) {
                        // 若最左下坐标数量大于1，直接返回false
                        return false;
                    }
                } else {
                    // 若不是最左下坐标，更新集合中非最顶点坐标的数量
                    String lb = rectangle[0] + "-" + rectangle[1];
                    map.put(lb, map.getOrDefault(lb, 0) + 1);
                }

                if (rectangle[0] == minX && rectangle[3] == maxY) {
                    // 最左上坐标数量加1
                    ++leftTopCount;
                    if (leftTopCount > 1) {
                        // 若最左上坐标数量大于1，直接返回false
                        return false;
                    }
                } else {
                    // 若不是最左上坐标，更新集合中非最顶点坐标的数量
                    String lt = rectangle[0] + "-" + rectangle[3];
                    map.put(lt, map.getOrDefault(lt, 0) + 1);
                }

                if (rectangle[2] == maxX && rectangle[1] == minY) {
                    // 最右下坐标数量加1
                    ++rightBottomCount;
                    if (rightBottomCount > 1) {
                        // 若最右下坐标数量大于1，直接返回false
                        return false;
                    }
                } else {
                    // 若不是最右下坐标，更新集合中非最顶点坐标的数量
                    String rb = rectangle[2] + "-" + rectangle[1];
                    map.put(rb, map.getOrDefault(rb, 0) + 1);
                }

                if (rectangle[2] == maxX && rectangle[3] == maxY) {
                    // 最右上坐标数量加1
                    ++rightTopCount;
                    if (rightTopCount > 1) {
                        // 若最右上坐标数量大于1，直接返回false
                        return false;
                    }
                } else {
                    // 若不是最右上坐标，更新集合中非最顶点坐标的数量
                    String rt = rectangle[2] + "-" + rectangle[3];
                    map.put(rt, map.getOrDefault(rt, 0) + 1);
                }
            }

            // 遍历集合，判断非最顶点坐标的数量是否都是成对出现，即数量是否都为2或4
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 2 && entry.getValue() != 4) {
                    // 若有非最顶点坐标的数量不等于2或4，返回false
                    return false;
                }
            }

            // 若最左下、最左上、最右下、最右上的四个点只出现一次，返回true
            return leftBottomCount == 1 && leftTopCount == 1 && rightBottomCount == 1 && rightTopCount == 1;
        }

        // 若小矩形面积之和不等于大矩形面积，直接返回false
        return false;
    }

}
```