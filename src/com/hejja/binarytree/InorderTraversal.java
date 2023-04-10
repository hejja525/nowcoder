package com.hejja.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点root，返回它的中序遍历结果。
 * https://www.nowcoder.com/practice/0bf071c135e64ee2a027783b80bf781d?tpId=295&tqId=1024572&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class InorderTraversal {

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
    public int[] inorderTraversal (TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        process(root, ans);
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public void process(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        process(root.left, ans);
        ans.add(root.val);
        process(root.right, ans);
    }
}
