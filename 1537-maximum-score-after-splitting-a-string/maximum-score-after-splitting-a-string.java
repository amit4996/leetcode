class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int[] noofZeroes=new int[s.length()];
        int[] noofOnes=new int[s.length()];

        int countZero=0;
        int countOne=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') {
               countZero++;
            }
            if(s.charAt(i)=='1'){
                countOne++;
            }
            noofZeroes[i]=countZero;
            noofOnes[i]=countOne;
        }
        int score=0;
        for(int i=0;i<s.length();i++){
            if(i==n-1) continue;
            score=Math.max(score,noofZeroes[i]+(noofOnes[n-1]-noofOnes[i]));
        }
        return score;
    }
}