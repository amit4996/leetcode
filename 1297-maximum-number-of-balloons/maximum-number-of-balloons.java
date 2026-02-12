class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> mp = new HashMap<>();

        for(char c:text.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        int result=Integer.MAX_VALUE;
        result=Math.min(result,mp.getOrDefault('b',0));
        result=Math.min(result,mp.getOrDefault('a',0));
        result=Math.min(result,mp.getOrDefault('l',0)/2);
        result=Math.min(result,mp.getOrDefault('o',0)/2);
        result=Math.min(result,mp.getOrDefault('n',0));

        return result;
    }
}