package com.something.algorithm.basic.sort;

import java.util.Arrays;

/**
 * 快速排序算法
 * <p>
 * 快排也是基于分治的思想，每次排序首先选取一个基准值k，然后遍历数组将之分为左右两部分，其中左半部分的元素统统小于基准值k，
 * 而右半部分的元素统统大于基准值k，这样整个数组就分为了一大一小两部分，但是两部分各自内部不保证有序。
 * 基于上述的处理方式，只需要在子数组中选取基准值，重复一分为二的操作，直到分到最小的单位即可完成排序。
 */
public class $06_QuickSort {


    public static void quickSort(int[] arr) {

        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快排算法 - 递归方式
     *
     * @param arr
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        /*
         * 一趟排序，当前序列分为左小右大两个子序列
         * 此处列举三种方式来完成一趟排序的工作
         */
        int keyIndex = partitionByLeftRightPointer(arr, left, right);
        // int keyIndex = partitionByMoveToPlace(arr, left, right);
        // int keyIndex = partitionByLeftRightPointer(arr, left, right);

        // 分别对左右两个序列进行排序
        quickSort(arr, left, keyIndex - 1);
        quickSort(arr, keyIndex + 1, right);
    }

    /**
     * 一趟快排算法，将给定区间[left, right]的数组元素按照基准值分成大小两部分
     * 方式一 ： 左右指针交换法
     *
     * @param arr
     * @param left
     * @param right
     */
    private static int partitionByLeftRightPointer(int[] arr, int left, int right) {
        // 选取区间内第一个元素为基准值
        int key = arr[left];
        int kindex = left;

        while (left < right) {
            // 从右向左找到第一个比key更小的值
            while (left < right && arr[right] >= key) {
                right--;
            }
            // 从左向右找到第一个比key更大的值
            while (left < right && arr[left] <= key) {
                left++;
            }
            // 交换找到的两个值的位置
            swap(arr, left, right);
        }

        swap(arr, kindex, left);
        return left;
    }

    /**
     * 一趟快排算法，将给定区间[left, right]的数组元素按照基准值分成大小两部分
     * 方式二 ：移动元素位置（占位法）
     *
     * @param arr
     * @param left
     * @param right
     */
    private static int partitionByMoveToPlace(int[] arr, int left, int right) {
        // 当前可占用的位置, 初始设置为基准值key的位置，在这里选取区间第一个元素
        int place = left;
        int key = arr[left];
        // 从右到左找到第一个小于key的元素，将之放至place的位置
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[place] = arr[right];
            place = right;

            // 从左到右找到第一个大于key的元素，将之放到place的位置
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[place] = arr[left];
            place = left;
        }

        // 最后将基准值放入place的位置
        arr[place] = key;
        return place;
    }

    /**
     * 一趟快排算法，将给定区间[left, right]的数组元素按照基准值分成大小两部分
     * 方式三 ：前后指针交换法
     *
     * @param arr
     * @param left
     * @param right
     */
    private static int partitionByFrontBehindPointer(int[] arr, int left, int right) {
        int key = arr[left];
        // behind指针保证其左侧的元素全部小于key
        int front, behind;
        front = behind = left;
        while (front <= right) {
            // front指针从左到右找到第一个比key大的元素，用behind指针记录
            while (front <= right && arr[front] <= key) {
                front++;
            }
            behind = front;
            // 继续找behind之后第一个小于key的元素
            while (front <= right && arr[front] >= key) {
                front++;
            }
            // 交换front和behind位置的元素
            swap(arr, front, behind);
            behind++;
        }

        // 将基准值放入对应位置
        swap(arr, left, behind - 1);
        return behind - 1;
    }


    /**
     * 交换给定数组left和right角标下的值
     * 此处不能使用与操作的方式，因为上层调用此方法时，
     * 可能存在left==right的情况，那么
     * arr[left] = arr[left] ^ arr[right]
     * arr[right] = arr[left] ^ arr[right]
     * arr[left] = arr[left] ^ arr[right]
     * 就由于arr[left]和arr[right]其实是同一个元素
     * 而导致交换失败
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {3, 22, -11, 53, 2521, 234};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
