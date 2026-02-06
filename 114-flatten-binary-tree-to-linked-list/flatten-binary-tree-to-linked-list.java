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
    public void flatten(TreeNode root) {
        helper(root); 
    }

    public TreeNode helper(TreeNode node){
         if(node == null) return null;

         TreeNode left=helper(node.left);
         TreeNode right=helper(node.right);

         if(node.left!=null && node.right!=null){
            TreeNode temp=node.right;
            node.right=node.left;
            node.left=null;
            while(node.right!=null){
                node=node.right;
            }
            node.right=temp;
         } else if(node.right==null){
            node.right=node.left;
            node.left=null;
         } else if(node.left==null){
            //do nothing
         }

         return node;

    }
}