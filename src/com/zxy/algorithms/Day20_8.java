package com.zxy.algorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Day20_8 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = null;
        treeNode.right = treeNode1;

        treeNode1.left = treeNode2;
        treeNode1.right = null;
        System.out.println("---二叉树的中序遍历---");
        List<Integer> list = inorderTraversal(treeNode);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        System.out.println();
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(2);
        root.left = rootLeft;
        root.right = rootRight;
        TreeNode l1Left = new TreeNode(3);
        TreeNode l1Right = new TreeNode(4);
        rootLeft.left = l1Left;
        rootLeft.right = l1Right;
        TreeNode r1Left = new TreeNode(4);
        TreeNode r1Right = new TreeNode(3);
        rootRight.left = r1Left;
        rootRight.right = r1Right;
        System.out.println(isSymmetric(root));
        System.out.println(maxDepth(root));
    }

    /**
     * 给定一个二叉树，找出其最大深度
     * [3,9,20,null,null,15,7]  3
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    /**
     * 二叉树 [1,2,2,3,4,4,3] 是对称的
     * [1,2,2,null,3,null,3] 则不是镜像对称的:
     */
    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
