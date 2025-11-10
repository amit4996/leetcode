class Solution {
    public int waysToMakeFair(int[] nums) {
        int n=nums.length;
        int[] evenPrefix=new int[n+1];
        int[] oddPrefix=new int[n+1];
        int totalEvenPrefix=0;
        int totalOddPrefix=0;
        for(int i=0;i<n;i++)
        {
            evenPrefix[i+1]=evenPrefix[i];
            oddPrefix[i+1]=oddPrefix[i];
            if(i%2==0){
                evenPrefix[i+1]+=nums[i];
            }else{
                oddPrefix[i+1]+=nums[i];
            }
        }

        int totalEven=evenPrefix[n];
        int totalOdd=oddPrefix[n];
        int count=0;
        for(int i=0;i<n;i++){
            int evenBefore=evenPrefix[i];
            int oddBefore=oddPrefix[i];
            int evenAfter=totalEven-evenPrefix[i+1];
            int oddAfter=totalOdd-oddPrefix[i+1];
            int newEven=evenBefore+oddAfter;
            int newOdd=oddBefore+evenAfter;
            if(newEven==newOdd) count++;

        }
        return count;

    }
}