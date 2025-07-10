class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        for(int i=1;i<n;i++){
            nums[i]+=nums[i-1];
        }
        for(int i=0;i<n;i++){
            System.out.println(nums[i]);
        }

        for(int i=0;i<n;i++){
            if(i==0 && nums[n-1]-nums[0]==0) return i;
            else
            if(i==n-1 && nums[i-1]==0) return i;
            else 
            if(i!=0 && i!=n-1 && nums[i-1]==nums[n-1]-nums[i]) return i;
        }
        return -1;
    }
}