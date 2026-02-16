class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        int count=0;
        int currCount=0;
        Integer prev=null;

        while(!pq.isEmpty()){
             int n1=pq.poll();
             if(prev!=null){
                if(n1-prev==1)
                    currCount++;
                else if(n1==prev) continue;
                else currCount=0;
             }
             count=Math.max(count,currCount);
             prev=n1;
        }

        return count+1;
    }
}