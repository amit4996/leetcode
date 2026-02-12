class Solution {
    public int maxProduct(int[] nums) {
        long currMax=nums[0];
        long currMin=nums[0];
        long maxProduct=nums[0];

        for(int i=1;i<nums.length;i++){
            long prevMax = currMax;
            long prevMin = currMin;
            currMax=Math.max(nums[i],Math.max(prevMax*nums[i],prevMin*nums[i]));
            currMin=Math.min(nums[i],Math.min(prevMax*nums[i],prevMin*nums[i]));
            maxProduct=Math.max(maxProduct,currMax);
        }

        return (int)(maxProduct);
    }
}