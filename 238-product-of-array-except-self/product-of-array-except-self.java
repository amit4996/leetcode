class Solution {
    // public int[] productExceptSelf(int[] nums) {
    //     int n=nums.length;
    //     int[] ans= new int[n];
    //     int[] prefixProduct=new int[n];
    //     int[] postfixProduct=new int[n];
    //     prefixProduct[0]=1;
    //     postfixProduct[n-1]=1;

    //     for(int i=1;i<n;i++){
    //         prefixProduct[i]=prefixProduct[i-1]*nums[i-1];
    //     }

    //     for(int i=n-2;i>=0;i--){
    //         postfixProduct[i]=postfixProduct[i+1]*nums[i+1];
    //     }

    //     for(int i=0;i<n;i++){
    //         ans[i]=prefixProduct[i]*postfixProduct[i];
    //     }

    //     return ans;
    // }

    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans= new int[n];
        
        ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }

        int right=1;

        for(int i=n-1;i>=0;i--){
            ans[i]=ans[i]*right;
            right*=nums[i];
        }
        return ans;
    }
}