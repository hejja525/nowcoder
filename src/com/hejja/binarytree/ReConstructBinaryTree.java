package com.hejja.binarytree;

/**
 * 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
 * @author hejja
 */
public class ReConstructBinaryTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        if (pre == null || vin == null || pre.length != vin.length) {
            return null;
        }
        return process(pre, 0, pre.length - 1, vin, 0, vin.length - 1);
    }

    public TreeNode process(int[] pre, int L1, int R1, int[] vin, int L2, int R2) {
        if (L1 > R1) {
            return null;
        }
        TreeNode root = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return root;
        }
        // 找到头节点
        int find = L2;
        while (pre[L1] != vin[find]) {
            find++;
        }
        root.left = process(pre, L1 + 1, L1 + (find - L2), vin, L2, find - 1);
        root.right = process(pre, L1 + (find - L2) + 1, R1, vin, find + 1, R2);
        return root;
    }
}
