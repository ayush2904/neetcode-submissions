/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int i = 1;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb= new StringBuffer();
        preorder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] a = data.split(",");
        //a = Arrays.copyOfRange(a, 1, a.length());
        TreeNode root = buildTree(a);
        return root;
    }

    public void preorder(TreeNode node, StringBuffer sb) {
        if(node==null) {
            sb.append(",null");
            return;
        }

        sb.append(","+node.val);
        preorder(node.left,sb);
        preorder(node.right,sb);
    }

    public TreeNode buildTree(String[] data) {
      String token = data[i++];
      if(i>=data.length || token.equals("null")) {
        return null;
      }

      TreeNode node = new TreeNode(Integer.parseInt(token));
      node.left = buildTree(data);
      node.right = buildTree(data);
      return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));