class Solution {
    public int pivotIndex(int[] nums) {
        
        int n=nums.length;
        if(n<0) return -1;
        if(n==1) return 0;
        int[] prefixSum = new int[n];
        int[] postfixSum = new int[n];

        prefixSum[0]=nums[0];
        postfixSum[n-1]=nums[n-1];

        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }

        for(int i=n-2;i>=0;i--){
            postfixSum[i]=postfixSum[i+1]+nums[i];
        }

        for(int i=0;i<n;i++){
            if(prefixSum[i]-nums[i]==postfixSum[i]-nums[i]){
                return i;
            }
        }

        return -1;

    }
}