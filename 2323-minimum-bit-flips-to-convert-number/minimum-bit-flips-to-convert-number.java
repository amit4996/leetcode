class Solution {
    public int minBitFlips(int start, int goal) {
        int xor=start^goal;

        int n=xor;
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
}