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
    int ans = 0;
    public int goodNodes(TreeNode root) {
        goodNodeHelper(root,Integer.MIN_VALUE);
        return ans;
    }

    public void goodNodeHelper(TreeNode root, int maxInPath) {
        if(root == null) return;
        
        if(root.val >= maxInPath) {
            ans++;
            maxInPath=root.val;
        }

        goodNodeHelper(root.left,maxInPath);
        goodNodeHelper(root.right,maxInPath);
    }
}
