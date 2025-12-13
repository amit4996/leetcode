class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int num:nums){
            xor=xor^num;
        }

        int diffBit=xor & -xor;
        int a=0,b=0;
        for(int num:nums){
            if((diffBit&num)==0){
                a=a^num;
            }
            else{
                b=b^num;
            }
        }
        return new int[]{a,b};

    }
}