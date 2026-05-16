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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null) return ans;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer(root);

        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            ans.add(list);
            list = new ArrayList<Integer>();

            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                
                if(node.left!=null) {
                 queue.offer(node.left);
                 list.add(node.left.val);
                }

                if(node.right!=null){
                queue.offer(node.right); 
                list.add(node.right.val);  
                }   
            }
        }

    return ans;
    }
}
