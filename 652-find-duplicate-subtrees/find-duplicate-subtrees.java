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
    Map<String,Integer> mp = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
         helper(root);
         return result;
    }

    public String helper(TreeNode node){
        if(node==null) return "#";

        String left=helper(node.left);
        String right=helper(node.right);

        String serialization= node.val+","+left+","+right;

        mp.put(serialization,mp.getOrDefault(serialization,0)+1);

        if(mp.get(serialization) == 2){
            result.add(node);
        }
        return serialization;
    }
}