package com.hejja.binarytree;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 1.对于该题的最近的公共祖先定义:对于有根树T的两个节点p、q，最近公共祖先LCA(T,p,q)表示一个节点x，满足x是p和q的祖先且x的深度尽可能大。在这里，一个节点也可以是它自己的祖先.
 * 2.二叉搜索树是若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值
 * 3.所有节点的值都是唯一的。
 * 4.p、q 为不同节点且均存在于给定的二叉搜索树中。
 * https://www.nowcoder.com/practice/d9820119321945f588ed6a26f0a6991f?tpId=295&tqId=2299105&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class LowestCommonAncestor {

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
     * @param p int整型
     * @param q int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        return process(root, p, q).ans.val;
    }

    public class Info {
        boolean findA;
        boolean findB;
        TreeNode ans;
        public Info(boolean findA, boolean findB, TreeNode ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }

    public Info process(TreeNode root, int a, int b) {
        if (root == null) {
            return new Info(false, false, null);
        }
        Info left = process(root.left, a, b);
        Info right = process(root.right, a, b);
        boolean findA = root.val == a || left.findA || right.findA;
        boolean findB = root.val == b || left.findB || right.findB;
        TreeNode ans = null;
        if (left.ans != null) {
            ans = left.ans;
        } else if (right.ans != null) {
            ans = right.ans;
        } else {
            if (findA && findB) {
                ans = root;
            }
        }
        return new Info(findA, findB, ans);
    }
}
