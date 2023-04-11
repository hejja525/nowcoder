package com.hejja.binarytree;

/**
 * 已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
 * https://www.nowcoder.com/practice/7298353c24cc42e3bd5f0e0bd3d1d759?tpId=295&tqId=634&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class MergeTrees {

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
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        return process(t1, t2);
    }

    public TreeNode process(TreeNode root1, TreeNode root2) {
        if (root1 == null ^ root2 == null) {
            return root1 == null ? root2 : root1;
        }
        if (root1 == null && root2 == null) {
            return null;
        }
        root1.val += root2.val;
        root1.left = process(root1.left, root2.left);
        root1.right = process(root1.right, root2.right);
        return root1;
    }
}
