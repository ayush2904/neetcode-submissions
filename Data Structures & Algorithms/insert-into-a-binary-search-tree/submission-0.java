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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        insert(root, val);
        return root;
    }

    public void insert(TreeNode node, int val) {
       // if(node==null) node = new TreeNode(val);

        if (node.val < val) {
            if (node.right != null)
                insert(node.right, val);
            else {
                node.right = new TreeNode(val);
                //System.out.println(node.right.val+"-"+node.val);
                return;
            }
        }
        if (node.val > val) {
            if (node.left != null)
                insert(node.left, val);
            else {
                node.left = new TreeNode(val);
               // System.out.println(node.left.val+"-"+node.val);
                return;
            }
        }
    }
}