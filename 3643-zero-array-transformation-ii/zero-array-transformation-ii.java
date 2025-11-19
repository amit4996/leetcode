class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int start=0;
        int end=queries.length-1;
        boolean allzero=true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) allzero=false;
        }
        if(allzero==true) return 0;

        if(!canMakeZero(nums,queries,end)){
            return -1;
        }
        int ans=-1;
        while(start<=end){
            int mid = start+(end-start)/2;

            if(canMakeZero(nums,queries,mid)){
                ans= mid+1;
                System.out.println("start end mid"+start+end+mid);
                end = mid-1; // check if it can make zeroes before 
            }
            else{
                start = mid+1; // check if it makes zero later
            }
        }
        return ans;
    }

    public boolean canMakeZero(int [] nums,int[][] queries,int k){
        int m=k;
        int n=nums.length;
        int[] diff=new int[n+1];
        int[] temp = nums.clone();   // IMPORTANT!

        for(int i=0;i<=m;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int val=queries[i][2];
            diff[l]-=val;
            if(r+1<diff.length) diff[r+1]+=val;
        }
        int currPrefixSum=0;
        for(int i=0;i<n;i++){
          currPrefixSum+=diff[i];
          int updatedVal=temp[i]+currPrefixSum;
          if(updatedVal>0) return false;
        }

        return true;
    }
}