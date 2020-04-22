package com.something.algorithm.util;

import java.util.function.Predicate;

public class ArrayUtil {

    private static final int DEFAULT_LENGTH = 10;

    private static final int MIN_VALUE = -100;

    private static final int MAX_VALUE = 100;

    public static int[] generateRandomArray() {
        return generateRandomArray(DEFAULT_LENGTH, MIN_VALUE, MAX_VALUE);
    }

    public static int[] generateRandomArray(int length) {
        return generateRandomArray(length, MIN_VALUE, MAX_VALUE);
    }

    /**
     * 生成随机数组
     *
     * @param length   数组长度
     * @param minValue 元素最小值
     * @param maxValue 元素最大值
     * @return
     */
    public static int[] generateRandomArray(int length, int minValue, int maxValue) {
        int[] arr = new int[length];
        int range = maxValue - minValue;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * range) + minValue;
        }
        return arr;
    }

    /**
     * 校验数组是否有序
     *
     * @param arr 待校验数组
     * @param asc 升序为true 降序为false
     * @return
     */
    public static boolean isOrdered(int[] arr, boolean asc) {
        Predicate<Integer> predicate = asc ? (sub) -> sub <= 0 : (sub) -> sub >= 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (!predicate.test(arr[i] - arr[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
