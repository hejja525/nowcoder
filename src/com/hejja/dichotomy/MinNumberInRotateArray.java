package com.hejja.dichotomy;

/**
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，
 * 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值。
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=295&tqId=1073463&ru=%2Fexam%2Fcompany&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class MinNumberInRotateArray {

    public static void main(String[] args) {
        int[] array = { 1,0,1,1,1 };
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(array));
    }

    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (array.length == 1) {
            return array[0];
        }
        int L = 0;
        int R = array.length - 1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (array[mid] < array[R]) {
                R = mid;
            } else if (array[mid] > array[R]) {
                L = mid + 1;
            } else {
                R--;
            }
        }
        return array[L];
    }
}
