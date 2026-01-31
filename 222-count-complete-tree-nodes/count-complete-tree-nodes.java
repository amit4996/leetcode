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
    // traversal way o(n)
    // public int countNodes(TreeNode root) {
    //     return helper(root);
    // }

    // public int helper(TreeNode root){
    //     if(root==null) return 0;
    //     return 1+helper(root.left)+helper(root.right);
    // }

    public int leftHeight(TreeNode root){
        int count=0;
        while(root.left!=null){
            root=root.left;
            count++;
        }
        return count;
    }

    public int rightHeight(TreeNode root){
        int count=0;
        while(root.right!=null){
            root=root.right;
            count++;
        }
        return count;
    }
    
    public int helper(TreeNode root) {
        if(root==null) return 0;
        int leftH=leftHeight(root);
        int rightH=rightHeight(root);
        if(leftH==rightH){
            // return 2^(leftHeight(root)+1)-1;
            return (int)Math.pow(2,leftH+1)-1;
        }
        return 1+helper(root.left)+helper(root.right);
    }

        public int countNodes(TreeNode root) {
        return helper(root);
    }
    
}