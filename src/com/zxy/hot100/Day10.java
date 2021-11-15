package com.zxy.hot100;

public class Day10 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode1_l = new TreeNode(3);
        treeNode1_l.left = new TreeNode(5);
        treeNode1.left = treeNode1_l;
        treeNode1.right = new TreeNode(2);

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode2_l = new TreeNode(1);
        TreeNode treeNode2_r = new TreeNode(3);
        treeNode2_l.right = new TreeNode(4);
        treeNode2_r.right = new TreeNode(7);
        treeNode2.left = treeNode2_l;
        treeNode2.right = treeNode2_r;
        TreeNode mergerTree = mergeTrees(treeNode1, treeNode2);
        System.out.println(mergerTree.val);
        System.out.println(mergerTree.left.val);
        System.out.println(mergerTree.right.val);
        TreeNode  mergerTreeLeft = mergerTree.left;
        System.out.println(mergerTreeLeft.left.val);
        System.out.println(mergerTreeLeft.right.val);
        TreeNode  mergerTreeRight = mergerTree.right;
        System.out.println(mergerTreeRight.right.val);
    }

    /**
     *         Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode mergerTree = new TreeNode(root1.val + root2.val);
        mergerTree.left = mergeTrees(root1.left, root2.left);
        mergerTree.right = mergeTrees(root1.right, root2.right);
        return mergerTree;
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
