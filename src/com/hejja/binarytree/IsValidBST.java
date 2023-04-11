package com.hejja.binarytree;

/**
 * 给定一个二叉树根节点，请你判断这棵树是不是二叉搜索树。
 *
 * 二叉搜索树满足每个节点的左子树上的所有节点均小于当前节点且右子树上的所有节点均大于当前节点。
 * https://www.nowcoder.com/practice/a69242b39baf45dea217815c7dedb52b?tpId=295&tqId=634&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class IsValidBST {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Info {
        boolean isValidBST;
        int min;
        int max;
        public Info(boolean isValidBST, int min, int max) {
            this.isValidBST = isValidBST;
            this.min = min;
            this.max = max;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isValidBST (TreeNode root) {
        return process(root).isValidBST;
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info left = process(root.left);
        Info right = process(root.right);
        int min = root.val;
        int max = root.val;
        boolean isValidBST = true;
        if (left != null) {
            isValidBST = left.isValidBST && root.val > left.max;
            min = Math.min(min, left.max);
        }
        if (right != null) {
            isValidBST = isValidBST && right.isValidBST && root.val < right.min;
            max = Math.max(max, right.max);
        }
        return new Info(isValidBST, min, max);
    }
}
