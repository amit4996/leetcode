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
    public TreeNode deleteNode(TreeNode root, int key) {
        return helper(root,key);
    }

    public TreeNode helper(TreeNode node,int key){
        if(node==null) return null;
        
        if(key<node.val){
            node.left=helper(node.left,key);
        } else if(key>node.val){
             node.right=helper(node.right,key);
        }
        else {
              if(node.left==null && node.right == null) return null;
              else if(node.left==null || node.right==null) return node.left==null?node.right:node.left;
              else {
                TreeNode predessor=inOrderPredessor(node.left);
                node.val=predessor.val;
                node.left = helper(node.left, predessor.val);
              }
        }
    return node; 
    }


    public TreeNode inOrderPredessor(TreeNode node){
         while(node.right!=null) node=node.right;
         return node;
       }
    
}