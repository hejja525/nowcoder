package com.hejja.dichotomy;

/**
 * 请实现无重复数字的升序数组的二分查找
 *
 * 给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标（下标从 0 开始），否则返回 -1
 * https://www.nowcoder.com/practice/d3df40bd23594118b57554129cadf47b?tpId=295&tqId=1073463&ru=%2Fexam%2Fcompany&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class SearchTarget {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int L = 0;
        int R = nums.length - 1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return -1;
    }
}
