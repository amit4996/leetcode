class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int totalSubArray=(i+1)*(n-i);
            int oddSubarrays = (totalSubArray + 1) / 2;
            sum+=arr[i]*oddSubarrays;
        }
        return sum;
    }
}