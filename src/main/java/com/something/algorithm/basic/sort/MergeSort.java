package com.something.algorithm.basic.sort;

import java.util.Arrays;

/**
 * 归并排序算法
 * <p>
 * 归并排序依据分而治之的思想(Divide and Conquer)，核心思路就是将数组分为几个子序列，首先保证子序列各自有序，再合并子序列。
 * 通常我们将带排序的数组一分为二，接着二分为四... 以此类推，即每个子序列都会由它的两个子序列合并而成，这也叫做二路归并。
 * <p>
 * <p>
 * 时间复杂度：O(n * log n)
 * <p>
 * 思考：
 * 算法在很多时候都是以空间来换取时间，在归并排序中也不例外。
 * 下面的实现方式，在每次的merge操作中都会新创建一个left+right长度的数组，空间复杂度为O(n2)，如何改进？
 * 是否可以在算法初始时，直接创建和原数组等长的新数组，在merge操作中不断填充这个新数组？这样改进之后空间复杂度可以降低为O(n)
 */
public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int[] mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 将数组一分为二
            int middle = left + ((right - left) >> 1);
            // 对左半部分排序
            int[] leftArr = mergeSort(arr, left, middle);
            // 对右半部分排序
            int[] rightArr = mergeSort(arr, middle + 1, right);
            // 合并左右两部分
            return merge(leftArr, rightArr);
        }

        System.out.println(left == right);
        return new int[]{arr[left]};
    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        // 申请一个新的数组，长度为左右两数组的长度之和
        int[] mergeArr = new int[leftArr.length + rightArr.length];
        int leftIndex = 0, rightIndex = 0, mergeIndex = 0;
        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            // 依次比较左右数组的元素值，较小的值放入新的大数组中
            mergeArr[mergeIndex++] = leftArr[leftIndex] > rightArr[rightIndex] ? rightArr[rightIndex++] : leftArr[leftIndex++];
        }

        // 若左部分数组有剩余元素，则继续填充到大数组中
        while (leftIndex < leftArr.length) {
            mergeArr[mergeIndex++] = leftArr[leftIndex++];
        }
        // 若右部分数组有剩余元素，则继续填充到大数组中
        while (rightIndex < rightArr.length) {
            mergeArr[mergeIndex++] = rightArr[rightIndex++];
        }

        return mergeArr;
    }


    public static void main(String[] args) {
        int[] arr = {3, 22, -11, 53, 2521, 234};
        int[] sorted = mergeSort(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
