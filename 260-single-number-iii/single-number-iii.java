class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int num:nums){
            xor=xor^num;
        }

        //to find neg of a number , flip the num in binary , add 1 in decimal,get binary 

        int diffBit=xor & -xor; // AND with n and -n gives last diff bit
        int a=0,b=0;
        for(int num:nums){
            if((diffBit&num)==0){ //group 1 which has diffBit 0
                a=a^num;
            }
            else{
                b=b^num;           //group 2 which has diffBit 1
            }
        }
        return new int[]{a,b};

    }
}