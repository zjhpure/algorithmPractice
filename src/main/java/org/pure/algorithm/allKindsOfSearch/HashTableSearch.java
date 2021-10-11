package org.pure.algorithm.allKindsOfSearch;

/**
 * @author zhangjianhua
 * @date 2021-10-11 19:31
 * @description 哈希查找
 */
public class HashTableSearch {

    // 原理尚未搞清，待解决

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 65, 6, 34, 67, 343, 56};
        System.out.println(hashSearch(arr, 67)); // true
        System.out.println(hashSearch(arr, 100)); // false
    }

    // 哈希结点
    private static class Node {
        int key; // 链表中的键
        Node next; // 下一个同义词
    }

    // 在哈希表中查找关键字key
    private static boolean hashSearch(int[] data, int key) {
        int p = 1;

        // 寻找小于或等于最接近表长的素数
        for (int i = data.length; i > 1; i--) {
            if (isPrimes(i)) {
                p = i;
                break;
            }
        }

        // 构建哈希表
        Node[] hashtable = createHashTable(data, p);

        // 查找key是否在哈希表中
        int k = key % p;

        Node cur = hashtable[k];

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
            Node node = new Node();

            node.key = datum;

            k = datum % p;

            if (hashtable[k] == null) {
                hashtable[k] = node;
            } else {
                Node current = hashtable[k];

                while (current.next != null) {
                    current = current.next;
                }

                current.next = node;
            }
        }

        return hashtable;
    }

    // 除余法构建哈希函数 用链表法解决哈希冲突
    private static boolean isPrimes(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
