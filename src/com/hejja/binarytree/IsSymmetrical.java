package com.hejja.binarytree;

/**
 * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 * https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=295&tqId=634&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class IsSymmetrical {

    public static void main(String[] args) {
        System.out.println(false ^ false);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        return process(pRoot, pRoot);
    }

    public boolean process(TreeNode root1, TreeNode root2) {
        if (root1 == null ^ root2 == null) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        return root1.val == root2.val && process(root1.left, root2.right) && process(root1.right, root2.left);
    }
}
