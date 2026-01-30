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
    //recursive way
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<>();
    //     preOrderHelper(root,result);
    //     return result;
    // }

    // public void preOrderHelper(TreeNode node,List<Integer> result){
    //     if(node == null) return;
    //     result.add(node.val);
    //     if(node.left!=null) preOrderHelper(node.left,result);
    //     if(node.right!=null) preOrderHelper(node.right,result);
    // }

    //Iterative way
    // public List<Integer> preorderTraversal(TreeNode root){
    //     List<Integer> result = new ArrayList<>();
    //     if(root==null) return result;
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);

    //     while(!stack.isEmpty()){
    //         TreeNode curr = stack.pop();
    //         result.add(curr.val);
    //         if(curr.right!=null) stack.push(curr.right);
    //         if(curr.left!=null) stack.push(curr.left);
    //     }

    //     return result;
    // }


    //Morris Traversal O(1)
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;

        TreeNode curr=root;

        while(curr!=null){
            //if no left exists : visit curr , move to right
            if(curr.left==null){
                result.add(curr.val);
                curr=curr.right;
            }
            //if left exists , find predessor
            else{
                TreeNode predessor = curr.left;
                while(predessor.right!=null && predessor.right!=curr){
                    predessor=predessor.right;
                }
                //if its first time getting to predessor for curr node
                // visit curr node , create a link to curr , advance to left subtree
                if(predessor.right==null){
                    predessor.right=curr;
                    result.add(curr.val);
                    curr=curr.left;
                }
                //if its second time getting predessor to curr node
                //break the link to restore tree structure
                //advance to right of curr because left is already covered
                else{
                    predessor.right=null;
                    curr=curr.right;
                }
            }
        }
        return result;
    }
}