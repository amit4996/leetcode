class Solution {
    public int pivotIndex(int[] nums) {
     int n=nums.length;
     if(n==0) return -1;
     if(n==1) return  0;
     int totalSum=0;
     int leftSum=0;
     for(int num:nums){
        totalSum+=num;
     }

     for(int i=0;i<n;i++){
        int rightSum=totalSum-leftSum-nums[i];
        if(rightSum==leftSum) return i;
        leftSum+=nums[i];
     }

     return -1;

    }
}