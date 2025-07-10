class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        int currSum=0;
        for(int i=0;i<n;i++){
            currSum+=nums[i];
            if(i==0 && totalSum-currSum==0){
                return i;
            }
            else if(i==n-1 && currSum-nums[i]==0){
                return i;
            }else
            if(currSum-nums[i]==totalSum-currSum){
                return i;
            }
        }
        return -1;
    }
}