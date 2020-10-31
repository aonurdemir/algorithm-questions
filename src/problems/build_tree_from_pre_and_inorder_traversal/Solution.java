package problems.build_tree_from_pre_and_inorder_traversal;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int rootIndex = -1;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        //fetch root from preorder
        //divide inorder according to root
        //recurse for left and then right

        return helper(preorder, inorder, 0, inorder.length);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int s, int e) {
        if (s >= e) return null;

        rootIndex++;

        int rootVal = preorder[rootIndex];
        int i = s;
        while (inorder[i] != rootVal) {
            i++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, inorder, s, i);
        root.right = helper(preorder, inorder, i + 1, e);

        return root;
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