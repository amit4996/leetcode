class Solution {
    public int majorityElement(int[] nums) {
        Integer candidate=null;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0) candidate=nums[i];

            if(nums[i]==candidate) count++;
            else
            count --;
        }

        return candidate;
    }
}