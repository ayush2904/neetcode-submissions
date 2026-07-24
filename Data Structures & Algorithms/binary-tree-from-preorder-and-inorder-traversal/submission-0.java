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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inMap = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++) {
            inMap.put(inorder[i],i);
        }
        return build(preorder, inMap, inorder, 0, inorder.length);
    }

    public TreeNode build(int[] preorder, HashMap<Integer, Integer> inMap, int[] inorder,int start, int end) {
        if(idx>=preorder.length) return null;
        if(start>end) return null;

        int val = preorder[idx++];
        TreeNode node = new TreeNode(val);
        int in = inMap.get(val);
        node.left = build(preorder, inMap, inorder, start, in-1);
        node.right = build(preorder, inMap, inorder, in+1, end);
        return node;
    } 
}