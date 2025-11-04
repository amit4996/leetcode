class Solution {
    // public boolean isValidSubArraySum(int[] prefixSum,int i,int j,int k){
    //     int start=i;
    //     int end=j;
    //     if(start>end || start<0 || end>=prefixSum.length) return false;
    //     int subArraySum=start>0?prefixSum[end]-prefixSum[start-1]:prefixSum[end];
    //     return subArraySum==k;
    // }
    // public int subarraySum(int[] nums, int k) {
    //     int n=nums.length;
    //     int count=0;

    //     int[] prefixSum=new int[n];
    //     prefixSum[0]=nums[0];

    //     for(int i=1;i<n;i++) prefixSum[i]=prefixSum[i-1]+nums[i];

    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             if(isValidSubArraySum(prefixSum,i,j,k)) count++;
    //         }
    //     }
    //     return count;
    // }

    public int subarraySum(int[] nums, int k) {
       int n=nums.length;
       Map<Integer,Integer> mp = new HashMap<>();
       mp.put(0,1);
        int prefixSum=0;
        int count=0;
        for(int i=0;i<n;i++){
            prefixSum+=nums[i];
            if(mp.containsKey(prefixSum-k)){
                count+=mp.get(prefixSum-k);
            }
            mp.put(prefixSum,mp.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}