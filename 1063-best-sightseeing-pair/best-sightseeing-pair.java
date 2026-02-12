class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int best=values[0]+0;
        int max=Integer.MIN_VALUE;

        for(int i=1;i<values.length;i++){
             max=Math.max(max,best+values[i]-i);
            if(values[i]+i>best){
                best=values[i]+i;
            }
        }

        return max;
    }
}