class Solution {
    // public int[] updatedArray(int[] nums,int l,int r){
    //     for(int i=l;i<=r;i++){
    //         if(nums[i]>0)
    //         nums[i]-=1;
    //         System.out.println(nums[i]);
    //     }

    //     return nums;
    // }
    // public boolean isZeroArray(int[] nums, int[][] queries) {
    //     int n=queries.length;
    //     int m=nums.length;
    //     for(int i=0;i<n;i++){
    //         int l=queries[i][0];
    //         int r=queries[i][1];
    //         // if(l<0||r>=m||r>l) continue;
    //         nums=updatedArray(nums,l,r);
    //     }

    //     for(int i=0;i<m;i++){
    //         if(nums[i]!=0) return false;
    //     }
    //     return true;
    // }

        public boolean isZeroArray(int[] nums, int[][] queries) {
        int m=queries.length;
        int n=nums.length;
        int[] diff=new int[n+1];
        for(int i=0;i<m;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            diff[l]-=1;
            if(r+1<n) diff[r+1]+=1;
        }
        int prefixDiffSum=0;
        for(int i=0;i<n;i++){
           prefixDiffSum+=diff[i];
           nums[i]+=prefixDiffSum;
           if(nums[i]<0) nums[i]=0;
           if(nums[i]!=0) return false;
        }

        // for(int i=0;i<m;i++){
        //     if(nums[i]!=0) return false;
        // }
        return true;
    }
}