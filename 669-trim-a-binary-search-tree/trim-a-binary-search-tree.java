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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
        if(root.val<low){
            return trimBST(root.right,low,high);
        }
        if(root.val>high){
            return trimBST(root.left,low,high);
        }
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
       return root;
    }

    // public TreeNode helper(TreeNode root, int low, int high){
    //     if(root==null) return null;
        
    //     root.left=helper(root.left,low,high);
    //     root.right=helper(root.right,low,high);
    //     System.out.println(root.val);
    //     if(root.val<low || root.val>high){
    //         System.out.println(root.val+"returning null");
    //         return null;
    //     }

    //     return root;
    // }
}