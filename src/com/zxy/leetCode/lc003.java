package com.zxy.leetCode;

import java.util.*;

/**
 * 树和图
 */
public class lc003 {
    public static void main(String[] args) {
        String msg = "2|4|1|2|1|3001|6+16++||购彩赠票活动已累计赠送2500016张|";
        String preSent = msg.substring(0, msg.indexOf("||"));
        String[] bet = preSent.split("\\|");
        System.out.println(Arrays.toString(bet));
        System.out.println(bet[6].substring(0, 1));
        System.out.println(bet[6].substring(bet[6].indexOf("+") + 1, bet[6].lastIndexOf("++")));
    }

    /**
     * 填充每个节点的下一个右侧节点指针
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;

        return null;
    }

    /**
     * 从前序与中序遍历序列构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(rootNode);
        int inIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preVal = preorder[i];
            TreeNode node = deque.peek();
            if (node.val != inorder[inIndex]) {
                node.left = new TreeNode(preVal);
                deque.push(node.left);
            } else {
                while (!deque.isEmpty() && deque.peek().val == inorder[inIndex]) {
                    node = deque.pop();
                    inIndex++;
                }
                node.right = new TreeNode(preVal);
                deque.push(node.right);
            }
        }
        return rootNode;
    }


    /**
     * 二叉树的锯齿形层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(level);
            leftToRight = !leftToRight;
        }
        return ans;
    }


    /**
     * 二叉树的中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> linkedList = new LinkedList<>();
        while (root != null || !linkedList.isEmpty()) {
            while (root != null) {
                linkedList.push(root);
                root = root.left;
            }
            root = linkedList.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public class TreeNode {
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

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
