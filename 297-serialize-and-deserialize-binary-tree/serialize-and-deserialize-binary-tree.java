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

   public String helper(TreeNode node){
        if(node==null) return "#";

        String left=helper(node.left);
        String right=helper(node.right);

        return node.val+","+left+","+right;
   }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // System.out.println(helper(root));
        // return postOrderHelper(TreeNode root);
        return helper(root);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        return build(tokens);
        // return null;
    }
    int idx=0;
    public TreeNode build(String[] tokens){
          String token=tokens[idx++];

          if(token.equals("#")) return null;
          TreeNode node = new TreeNode(Integer.parseInt(token));
          node.left=build(tokens);
          node.right=build(tokens);
          return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));