package com.hejja.binarytree;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=295&tqId=634&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class Mirror {

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
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror (TreeNode pRoot) {
        return process(pRoot);
    }

    public TreeNode process(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = process(root.left);
        TreeNode right = process(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
