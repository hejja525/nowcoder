package com.hejja.dichotomy;

/**
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=295&tqId=1073463&ru=%2Fexam%2Fcompany&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class TwoFind {

    public static void main(String[] args) {
        int[][] array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        int target = 5;
        System.out.println(new TwoFind().Find(target, array));
    }

    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rowStart = 0;
        int rowEnd = array[0].length - 1;
        int colStart = 0;
        int colEnd = array.length - 1;
        while (rowStart < rowEnd || colStart < colEnd) {
            if (rowStart < rowEnd) {
                rowEnd = findRowRightMin(target, array, rowStart, rowEnd);
                if (array[rowStart][rowEnd] == target) {
                    return true;
                }
                rowStart++;
            }
            if (colStart < colEnd) {
                colEnd = findColRightMin(target, array, colStart, colEnd);
                if (array[colEnd][colStart] == target) {
                    return true;
                }
                colStart++;
            }
        }
        return array[colStart][colEnd] == target;
    }

    public int findRowRightMin(int target, int[][] array, int start, int end) {
        int L = start;
        int R = end;
        int mid = 0;
        int index = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (array[start][mid] <= target) {
                L = mid + 1;
                index = mid;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }

    public int findColRightMin(int target, int[][] array, int start, int end) {
        int L = start;
        int R = end;
        int mid = 0;
        int index = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (array[mid][start] <= target) {
                L = mid + 1;
                index = mid;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }
}
