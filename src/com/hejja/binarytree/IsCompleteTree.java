package com.hejja.binarytree;

/**
 * 给定一个二叉树，确定他是否是一个完全二叉树。
 * https://www.nowcoder.com/practice/8daa4dff9e36409abba2adbe413d6fae?tpId=295&tqId=2299105&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class IsCompleteTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isCompleteTree (TreeNode root) {
        return process(root).isCBT;
    }

    public class Info {
        // 是不是满二叉树
        boolean isFull;
        // 是不是完全二叉树
        boolean isCBT;
        // 最大高度
        int max;

        public Info(boolean isFull, boolean isCBT, int max) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.max = max;
        }
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, true, 0);
        }
        Info left = process(root.left);
        Info right = process(root.right);
        boolean isFull = left.isFull && right.isFull && left.max == right.max;
        boolean isCBT = false;
        if (left.isFull && right.isFull && (left.max == right.max || left.max == right.max + 1)) {
            isCBT = true;
        } else if (left.isCBT && right.isFull && left.max == right.max + 1) {
            isCBT = true;
        } else if (left.isFull && right.isCBT && left.max == right.max) {
            isCBT = true;
        }
        int max = Math.max(left.max, right.max) + 1;
        return new Info(isFull, isCBT, max);
    }
}
