package org.pure.algorithm.allKindsOfSearch;

/**
 * @author zhangjianhua
 * @date 2021-10-11 19:31
 * @description 哈希查找
 */
public class HashTableSearch {

    // 哈希查找：如果所有的键都是整数，那么就可以使用一个简单的无序数组来实现：将键作为索引，值即为其对应的值，这样就可以快速访问任意键的值
    // 注意：用给定的哈希函数构造哈希表；根据选择的冲突处理方法解决地址冲突；在哈希表的基础上执行哈希查找
    // 常见的解决冲突的方法：拉链法和线性探测法
    // 哈希查找：把数据保存成一个Node数组，如果有数据落到同一个Node上，那么因为Node是链表，所以添加到链表的后面，查找数据时先确定是哪个Node，然后再从Node链表中寻找对应的数据

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 65, 6, 34, 67, 343, 56};

        // 定义取余数
        int p = 1;

        // 寻找小于或等于最接近表长的素数，以此作为取余数
        for (int i = arr.length; i > 1; --i) {
            if (isPrimes(i)) {
                p = i;
                break;
            }
        }

        // 构建哈希表
        Node[] hashtable = createHashTable(arr, p);

        System.out.println(hashSearch(hashtable, p, 67)); // true
        System.out.println(hashSearch(hashtable, p, 100)); // false
    }

    // 哈希结点
    private static class Node {
        int key; // 链表中的键
        Node next; // 下一个同义词
    }

    // 在哈希表中查找关键字key
    private static boolean hashSearch(Node[] hashtable, int p, int key) {
        // 查找key是否在哈希表中
        int k = key % p;

        // 获取找到的哈希节点
        Node cur = hashtable[k];

        // 遍历哈希节点，寻找和关键字key相等的值
        while (cur != null && cur.key != key) {
            cur = cur.next;
        }

        return cur != null;
    }

    // 用求余，链表法构建哈希表
    private static Node[] createHashTable(int[] data, int p) {
        Node[] hashtable = new Node[p];

        // 哈希函数计算的单元地址
        int k;

        for (int datum : data) {
            // 创建节点对象node
            Node node = new Node();

            // 节点对象的值为数组的当前数据
            node.key = datum;

            // 根据数组的当前数据计算出哈希数组的单元地址，即下标，通过取余法计算
            k = datum % p;

            if (hashtable[k] == null) {
                // 若这个下标不存在哈希Node，直接保存节点对象node进去
                hashtable[k] = node;
            } else {
                // 若这个下标已经存在哈希Node，遍历到Node最后，在最后插入节点对象node
                Node current = hashtable[k];

                while (current.next != null) {
                    current = current.next;
                }

                current.next = node;
            }
        }

        return hashtable;
    }

    // 除余法构建哈希函数，用链表法解决哈希冲突
    private static boolean isPrimes(int n) {
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
