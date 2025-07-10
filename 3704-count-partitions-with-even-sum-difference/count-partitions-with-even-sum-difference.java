class Solution {
    public int countPartitions(int[] nums) {
        int count=0;
        int n=nums.length;
        int totalSum=0;

        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        int currSum=0;
        for(int i=0;i<n-1;i++){
            currSum+=nums[i];
            int diff=currSum-(totalSum-currSum);
            if(diff%2==0) count++;
        }
        return count;
    }
}