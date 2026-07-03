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
    public TreeNode deleteNode(TreeNode root, int key) {
       return delete(root, key);
    }

    public TreeNode delete(TreeNode node, int val) {
        if(node==null) return null;

        if(node.val > val) {
           node.left = delete(node.left,val);
        } else if (node.val < val) {
           node.right = delete(node.right, val);
        } else {
            if(node.right==null) { 
               return node.left;
            }
            else if(node.left==null) {
               return node.right;
            }
            else if(node.left!=null && node.right!=null){
                TreeNode succ = node.right;

                while(succ.left != null) {
                    succ = succ.left;
                }

                node.val = succ.val;
                node.right = delete(node.right, succ.val);
            }
        }
        return node;
    }
}