class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n>0){
            if((n&1)==1) count++;//== has higher precedene in java so need backets
            n=n>>1;
        }
        return count;
    }
}