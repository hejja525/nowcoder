package com.hejja.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列号和反序列化
 * ！！！中序不能序列化，两个不相同的树，可以序列化成相同的字符串！！！
 * https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=295&tqId=2299105&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * @author hejja
 */
public class SerializeAndDeserialize {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node6;
        node3.right = node7;
        String serialize = new SerializeAndDeserialize().Serialize(node1);
        System.out.println(serialize);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    String Serialize(TreeNode root) {
        return preSerial(root);
    }
    TreeNode Deserialize(String str) {
        return dePreSerial(str);
    }

    // 先序序列化
    public String preSerial(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        pre(root, queue);
        StringBuilder builder = new StringBuilder();
        queue.forEach(item -> builder.append(item).append(","));
        String str = builder.toString();
        return str.substring(0, str.length() - 1);
    }

    public void pre(TreeNode root, Queue<String> queue) {
        if (root == null) {
            queue.offer("#");
            return;
        }
        queue.offer(root.val + "");
        pre(root.left, queue);
        pre(root.right, queue);
    }

    // 先序序列化
    public TreeNode dePreSerial(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] split = str.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.offer(s);
        }
        return dePre(queue);
    }

    public TreeNode dePre(Queue<String> queue) {
        String value = queue.poll();
        if (value == null || value.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = dePre(queue);
        node.right = dePre(queue);
        return node;
    }
}
