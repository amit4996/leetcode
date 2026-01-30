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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        // if(root==null) return result;
        String temp="";
        helper(root,result,temp);
        return result;
    }

    public void helper(TreeNode curr,List<String> result,String temp){
        if(curr==null) return ;
        temp+=curr.val;
        if (curr.left == null && curr.right == null) {
            result.add(temp);
            return;
        }
        temp+="->";
        helper(curr.left,result,temp);
        helper(curr.right,result,temp);
    }
}