class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        int currSum=0;
        int[] answer=new int[n];

        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }

        for(int i=0;i<n;i++){
            currSum+=nums[i];
            answer[i]=Math.abs((currSum-nums[i])-(totalSum-currSum));
        }
        return answer;



    }
}