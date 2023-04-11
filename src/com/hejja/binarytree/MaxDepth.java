package com.hejja.binarytree;

/**
 * 求给定二叉树的最大深度，
 * 深度是指树的根节点到任一叶子节点路径上节点的数量。
 * 最大深度是所有叶子节点的深度的最大值。
 * （注：叶子节点是指没有子节点的节点。）
 * https://www.nowcoder.com/practice/8a2b2bf6c19b4f23a9bdb9b233eefa73?tpId=295&tqId=1024572&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class MaxDepth {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth (TreeNode root) {
        return process(root);
    }

    public int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = process(root.left);
        int right = process(root.right);
        return Math.max(left, right) + 1;
    }
}
