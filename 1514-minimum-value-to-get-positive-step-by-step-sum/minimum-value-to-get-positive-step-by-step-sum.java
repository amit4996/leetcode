class Solution {
    public int minStartValue(int[] nums) {
        int cSum=0;
        int startValue=1;
        for(int i=0;i<nums.length;i++){
            cSum+=nums[i];
            System.out.println(cSum);
            startValue=Math.max(startValue,1-cSum);
        }
        return startValue;
    }
}