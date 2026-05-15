/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return ans;
        isBalancedHelper(root);
        return ans;
    }

    public int isBalancedHelper(TreeNode root) {
        if(root==null) return -1;
        if(ans==false) return 0;

        int leftHeight = 1 + isBalancedHelper(root.left);
        int rightHeight = 1 + isBalancedHelper(root.right);
        //System.out.println(leftHeight+" - "+rightHeight+" _ "+root.val);
        if(Math.abs(leftHeight-rightHeight)>1) ans=false;
        return Math.max(leftHeight, rightHeight);
    }
}
