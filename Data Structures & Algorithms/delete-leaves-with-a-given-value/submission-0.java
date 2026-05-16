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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        root = util(root,target);
        return root;
    }

    public TreeNode util(TreeNode node , int target) {
        if(node == null) return null;

        node.left = util(node.left, target);
        node.right = util(node.right, target);

        if(node.val==target && node.left == null && node.right == null) {
            //System.out.println("making this node null "+ node.val);
            node = null ;
        }

        return node;
    }
}