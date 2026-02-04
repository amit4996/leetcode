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
    int ans=0;
    public int sumRootToLeaf(TreeNode root) {
        String currBinaryString="";
        helper(root,currBinaryString);
        return ans;
    }
    public void helper(TreeNode node,String currBinaryString){
        if(node==null) return;
        currBinaryString+=node.val;
        if(node.left==null && node.right==null) 
        ans+=Integer.parseInt(currBinaryString,2);

        helper(node.left,currBinaryString);
        helper(node.right,currBinaryString);
    }
}