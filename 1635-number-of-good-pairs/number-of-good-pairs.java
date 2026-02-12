class Solution {
    Map<Integer,Integer> mp= new HashMap<>();
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        for(int num:nums){
            int freq=mp.getOrDefault(num,0);
            count+=freq;
            mp.put(num,freq+1);
        }
        return count;
    }
}