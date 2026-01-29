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
    // public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //     //BFS using boolean and reverse logic 
    //     List<List<Integer>> result = new ArrayList<>();
    //     if(root == null ) return result;
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.offer(root);
    //     boolean isLeftToRight = true;
    //     while(!q.isEmpty()){
    //         int size =  q.size();
    //         List<Integer> level = new ArrayList<>();
    //         for(int i=0;i<size;i++){
    //             TreeNode curr = q.poll();
    //             level.add(curr.val);
    //             if(curr.left !=null) q.offer(curr.left);
    //             if(curr.right != null) q.offer(curr.right);
    //         }
    //         if(isLeftToRight != true){
    //             Collections.reverse(level);
    //         }
    //         result.add(level);
    //         isLeftToRight=!isLeftToRight;
    //     }

    //     return result;

    // }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //BFS using deque , decide order of insertion
        List<List<Integer>> result = new ArrayList<>();
        if(root == null ) return result;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerFirst(root);
        boolean isLeftToRight = true;
        while(!q.isEmpty()){
            int size =  q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                if(isLeftToRight == true){
                    TreeNode curr = q.pollFirst();
                    level.add(curr.val);
                    if(curr.left !=null) q.offerLast(curr.left);
                    if(curr.right != null) q.offerLast(curr.right);
                }else{
                    TreeNode curr = q.pollLast();
                    level.add(curr.val);
                    if(curr.right != null) q.offerFirst(curr.right);
                    if(curr.left !=null) q.offerFirst(curr.left);
                }
                
            }
            result.add(level);
            isLeftToRight=!isLeftToRight;
        }
        return result;
    }
}