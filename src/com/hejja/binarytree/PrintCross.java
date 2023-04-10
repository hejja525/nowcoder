package com.hejja.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 * https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=295&tqId=1024572&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class PrintCross {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(pRoot);
        int size = 0;
        boolean isHead = true;
        while (!deque.isEmpty()) {
            size = deque.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = isHead ? deque.pollFirst() : deque.pollLast();
                level.add(cur.val);
                if (isHead) {
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                }
            }
            isHead = !isHead;
            result.add(level);
        }
        return result;
    }
}
