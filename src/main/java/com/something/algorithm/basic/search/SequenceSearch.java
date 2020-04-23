package com.something.algorithm.basic.search;

import com.something.algorithm.basic.sort.$06_QuickSort;
import com.something.algorithm.util.ArrayUtil;

import java.util.Arrays;

/**
 * 顺序查找
 * <p>
 * 适用场景：任意数组
 * 时间复杂度 O(n)
 */
public class SequenceSearch {

    /**
     * @param array  给定的一维数组
     * @param target 要查找的目标元素
     * @return 返回目标元素在数组中的下标，没有则返回-1
     */
    public static int sequenceSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        // 生成一个随机数组
        int length = 20;
        int[] arr = ArrayUtil.generateRandomArray(length);
        System.out.println("给定数组 ：" + Arrays.toString(arr));

        // 随机给定一个数组的元素
        int randomIndex = (int) (Math.random() * (length - 1));
        int target = arr[randomIndex];
        System.out.println("查找第 " + (randomIndex + 1) + " 个元素 ：" + target);

        System.out.println("返回角标 ：" + sequenceSearch(arr, target));
    }
}
