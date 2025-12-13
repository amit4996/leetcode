class Solution {
    // public int hammingWeight(int n) {
    //     int count=0;
    //     while(n>0){
    //         if((n&1)==1) count++;//== has higher precedene in java so need backets
    //         n=n>>1;
    //     }
    //     return count;
    // }
    // TC O(n)

    //Brian Kernighan’s Algorithm for counting set bits
        public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
    //TC O(set bits)
}