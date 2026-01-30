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
        String path="";
        helper(root,result,path);
        return result;
    }

    public void helper(TreeNode curr,List<String> result,String path){
        if(curr==null) return ;
        path+=curr.val;
        if (curr.left == null && curr.right == null) {
            result.add(path);
            return;
        }
        path+="->";
        helper(curr.left,result,path);
        helper(curr.right,result,path);
    }
}