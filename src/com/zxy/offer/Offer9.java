package com.zxy.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer9 {
    public static void main(String[] args) {

    }

    /**
     * 对称的二叉树
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isRecur(root.left, root.right);
    }

    public boolean isRecur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isRecur(left.left, right.right) && isRecur(left.right, right.left);
    }

    /**
     * 二叉树的镜像(请完成一个函数，输入一个二叉树，该函数输出它的镜像。)
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * *****************************
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 树的子结构
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    /**
     * 从上到下打印二叉树 III
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     */
    public List<List<Integer>> levelOrderThree(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root != null) {
            linkedList.add(root);
        }
        while (!linkedList.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                if (list.size() % 2 == 0) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);
                }
                if (node.left != null) linkedList.add(node.left);
                if (node.right != null) linkedList.add(node.right);
            }
            list.add(temp);
        }
        return list;
    }

    /**
     * 从上到下打印二叉树II
     */
    public List<List<Integer>> levelOrderList(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root != null) {
            linkedList.add(root);
        }
        while (!linkedList.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                temp.add(node.val);
                if (node.left != null) linkedList.add(node.left);
                if (node.right != null) linkedList.add(node.right);
            }
            list.add(temp);
        }
        return list;
    }

    /**
     * 从上到下打印二叉树
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        List<Integer> list = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.poll();
            list.add(node.val);
            if (node.left != null) linkedList.add(node.left);
            if (node.right != null) linkedList.add(node.right);
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
