package com.hejja.binarytree;

import java.util.ArrayList;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * https://www.nowcoder.com/practice/5e2135f4d2b14eb8a5b06fab4c938635?tpId=295&tqId=1024572&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class PreorderTraversal {

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
     * @return int整型一维数组
     */
    public int[] preorderTraversal (TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        process(root, ans);
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public void process(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        process(root.left, ans);
        process(root.right, ans);
    }
}
