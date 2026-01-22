class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int curr=0;
        int lastZero=-1;
        while(curr<n){
            if(nums[curr]==0 && lastZero==-1){
                lastZero=curr;
            }
            else if(nums[curr]!=0 && lastZero!=-1){
                nums[lastZero]=nums[curr];
                nums[curr]=0;
                lastZero++;
            }
            curr++;
        }
    }
}