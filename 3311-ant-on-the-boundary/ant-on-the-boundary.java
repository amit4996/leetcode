class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int currSum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
           currSum+=nums[i];
           if(currSum==0) count++;
        }
        return count;

    }
}