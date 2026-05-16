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
    int ans = -1;
    int rank=0;
    public int kthSmallest(TreeNode root, int k) {
        util(root,k);
        return ans;
    }

    public int util(TreeNode root, int k) {
        if(root==null) {
            return 0;
        }
        if(ans!=-1) return ans;

        util(root.left, k);
        rank++;
        if(rank==k && ans==-1) { 
            ans = root.val;
            return ans;
        }
        util(root.right, k);
        return ans;
    }
}
