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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<to_delete.length;i++){
            set.add(to_delete[i]);
        }
        List<TreeNode> result = new ArrayList<>();
        helper(root,true,set,result);
        return result;
    }

    public TreeNode helper(TreeNode node,boolean isParentDeleted,Set<Integer> set,List<TreeNode> result){
        if(node==null) return null;
        boolean toBeDeleted = set.contains(node.val);
        if(isParentDeleted && !toBeDeleted){
            result.add(node);
        }
        node.left = helper(node.left,toBeDeleted,set,result);
        node.right = helper(node.right,toBeDeleted,set,result);
        return toBeDeleted?null:node;
    }
}