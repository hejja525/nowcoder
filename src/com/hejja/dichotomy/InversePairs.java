package com.hejja.dichotomy;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P mod 1000000007
 *
 * https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=295&tqId=1073463&ru=%2Fexam%2Fcompany&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class InversePairs {

    public static void main(String[] args) {
        int[] array = { 1,2,3,8,5,6,7,0 };
        System.out.println(new InversePairs().InversePairs(array));
    }

    public static int mod = 1000000007;

    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return process(array, 0, array.length - 1);
    }

    public int process(int[] array, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return (process(array, L, mid) + process(array, mid + 1, R) + merge(array, L, mid, R)) % mod;
    }

    public int merge(int[] array, int L, int M, int R) {
        int num = 0;
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = M + 1;
        int index = 0;
        while (p1 <= M && p2 <= R) {
            if (array[p1] > array[p2]) {
                help[index++] = array[p2++];
                num = (num + ((M - p1 + 1) % mod)) % mod;
            } else {
                help[index++] = array[p1++];
            }
        }
        while (p1 <= M) {
            help[index++] = array[p1++];
        }
        while (p2 <= R) {
            help[index++] = array[p2++];
        }
        for (index = 0; index < help.length; index++) {
            array[L + index] = help[index];
        }
        return num;
    }

    public int getMod(int num) {
        return num % mod;
    }
}
