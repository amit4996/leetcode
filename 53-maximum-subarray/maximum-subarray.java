class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length<=0) return 0;
        int currSum=nums[0];
        int maxSum=nums[0];

        int tempStart=0,start=0,end=0;

        for(int i=1;i<nums.length;i++){
            if(nums[i]>currSum+nums[i]){
                currSum=nums[i];
                tempStart=i;
            }else{
                currSum=currSum+nums[i];
            }

            if(currSum>maxSum){
                maxSum=currSum;
                start=tempStart;
                end=i;
            }
        }

        return maxSum;
    }
}