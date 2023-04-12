package com.hejja.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图[按层打印]
 * https://www.nowcoder.com/practice/c9480213597e45f4807880c763ddd5f0?tpId=295&tqId=2299105&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class PrintRight {

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,6,3};
        int[] vin = {5,4,6,2,1,3};
        System.out.println(Arrays.toString(new PrintRight().solve(pre, vin)));;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @param xianxu int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve (int[] xianxu, int[] zhongxu) {
        if (xianxu == null || zhongxu == null || xianxu.length != zhongxu.length) {
            return null;
        }
        TreeNode root = process(xianxu, 0, xianxu.length - 1, zhongxu, 0, zhongxu.length - 1);
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    ans.add(node.val);
                }
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public TreeNode process(int[] pre, int L1, int R1, int[] vin, int L2, int R2) {
        if (L1 > R1) {
            return null;
        }
        TreeNode root = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return root;
        }
        int find = L2;
        while (pre[L1] != vin[find]) {
            find++;
        }
        root.left = process(pre, L1 + 1, L1 + (find - L2), vin, L2, find - 1);
        root.right = process(pre, L1 + (find - L2) + 1, R1, vin, find + 1, R2);
        return root;
    }
}
