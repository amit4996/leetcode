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
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     //BFS
    //     List<List<Integer>> result = new ArrayList<>();
    //             if(root==null) return result;

    //     Queue<TreeNode> queue = new LinkedList<>();

    //     queue.offer(root);

    //     while(!queue.isEmpty()){
    //         int size = queue.size();
    //         List<Integer> level = new ArrayList<>();
    //         for(int i=0;i<size;i++){
    //             TreeNode curr = queue.poll();
    //             level.add(curr.val);
    //             if(curr.left!=null) queue.offer(curr.left);
    //             if(curr.right!=null) queue.offer(curr.right);
    //         }
    //         result.add(level);
    //     }
    //     return result;
    // }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //DFS
        List<List<Integer>> result = new ArrayList<>();
                if(root==null) return result;
        levelOrderHelper(root,0,result);
        return result;
        
    }

    public void levelOrderHelper(TreeNode node,int depth,List<List<Integer>> result){
        if(node == null) return;
        if(depth == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(node.val);
        if(node.left!=null) levelOrderHelper(node.left,depth+1,result);
        if(node.right!=null) levelOrderHelper(node.right,depth+1,result);
    }
}