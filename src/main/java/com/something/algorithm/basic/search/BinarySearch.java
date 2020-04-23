package com.something.algorithm.basic.search;

import com.something.algorithm.basic.sort.$06_QuickSort;
import com.something.algorithm.util.ArrayUtil;

import java.util.Arrays;

/**
 * 二分查找算法
 * <p>
 * 适用场景：给定的集合必须有序
 * 时间复杂度 O(log n)
 */
public class BinarySearch {

    /**
     * @param arr    给定的一维数组(这里假设正序)
     * @param target 要查找的目标元素
     * @return 返回目标元素在数组中的下标，没有则返回-1
     */
    public static int binarySearchWithLoop(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int middle;

        while (left <= right) {
            // 这里采用位运算，防止数组过大的情况下，出现：left + right > Integer.MAX_VALUE
            middle = left + ((right - left) >> 1);
            if (arr[middle] == target) {
                return middle;
            }

            if (arr[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }


    /**
     * 递归方式实现
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchRecursively(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = left + ((right - left) >> 1);
        if (arr[middle] == target) {
            return middle;
        }
        if (arr[middle] > target) {
            return binarySearchRecursively(arr, target, left, middle - 1);
        } else {
            return binarySearchRecursively(arr, target, middle + 1, right);
        }
    }

    public static void main(String[] args) {
        // 生成一个随机数组
        int length = 20;
        int[] arr = ArrayUtil.generateRandomArray(length);
        // 对数组排序
        $06_QuickSort.quickSort(arr);
        System.out.println("给定数组 ：" + Arrays.toString(arr));

        // 随机给定一个数组的元素
        int randomIndex = (int) (Math.random() * (length - 1));
        int target = arr[randomIndex];
        System.out.println("查找第 " + (randomIndex + 1) + " 个元素 ：" + target);

        // 分别使用两种实现方式的二分查找
        int resultWithLoop = binarySearchWithLoop(arr, target);
        int resultWithRecursive = binarySearchRecursively(arr, target, 0, arr.length - 1);
        System.out.println("递归方式的二分查找 ：" + resultWithRecursive);
        System.out.println("循环方式的二分查找 ：" + resultWithLoop);
    }
}
