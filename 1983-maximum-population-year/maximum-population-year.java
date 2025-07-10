class Solution {
    public int maximumPopulation(int[][] logs) {
        TreeMap<Integer,Integer> mp= new TreeMap<>();

        for(int[] log:logs){
            if(mp.get(log[0])!=null){
                 mp.put(log[0],mp.get(log[0])+1);
            }
            else
            mp.put(log[0],1);

             if(mp.get(log[1])!=null){
                mp.put(log[1],mp.get(log[1])-1);
            }
            else
            mp.put(log[1],-1);
        }
        int currPop=0;
        int maxPop=0;
        int earlierYear=0;
        for(int year:mp.keySet()){
            currPop+=mp.get(year);
            if(currPop>maxPop){
                maxPop=currPop;
                earlierYear=year;
            }
        }
        return earlierYear;
    }
}