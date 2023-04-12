package com.hejja.binarytree;

/**
 * 输入一棵节点数为 n 二叉树，判断该二叉树是否是平衡二叉树。
 * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=295&tqId=2299105&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class IsBalancedTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return process(root).isBalanced;
    }

    public class Info {
        boolean isBalanced;
        int height;
        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info left = process(root.left);
        Info right = process(root.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;
        return new Info(isBalanced, height);
    }
}
