## 源码路径

/src/main/java/org/pure/algorithm/mapSumPairs/Main.java

## 题目地址(键值映射)

https://leetcode-cn.com/problems/map-sum-pairs

## 题目描述

```
实现一个MapSum类，支持两个方法，insert和sum：

MapSum()初始化MapSum对象
void insert(String key, int val)插入key-val键值对，字符串表示键key，整数表示值val。如果键key已经存在，那么原来的键值对将被替代成新的键值对。
int sum(string prefix)返回所有以该前缀prefix开头的键key的值的总和。

示例：

输入：
["MapSum", "insert", "sum", "insert", "sum"]
[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
输出：
[null, null, 3, null, 5]

解释：
MapSum mapSum = new MapSum();
mapSum.insert("apple", 3);  
mapSum.sum("ap");           // return 3 (apple = 3)
mapSum.insert("app", 2);    
mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)

提示：

1 <= key.length, prefix.length <= 50
key和prefix仅由小写英文字母组成
1 <= val <= 1000
最多调用50次insert和sum
```

## 代码

- 语言：Java

```
class MapSum {

    // 暴力法

    // 定义map集合
    private Map<String, Integer> map;

    /** Initialize your data structure here. */
    public MapSum() {
        // map初始化
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        // 直接保存到map集合中
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        // 定义前缀总和
        int sum = 0;

        // 遍历map集合的键
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                // 若键以prefix开头，那么累加键对应的值到前缀总和中
                sum += map.get(key);
            }
        }
        
        // 返回前缀总和
        return sum;
    }

}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
```