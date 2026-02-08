class Solution {

    //recursive way
    // public boolean isSubsequence(String s, String t) {
    //     int idxS=0;
    //     int idxT=0;
    //     return helper(s,t,idxS,idxT);
    // }

    // public boolean helper(String s,String t,int idxS,int idxT){
    //     if(idxS==s.length()) return true;
    //     if(idxT==t.length()) return false;
    //     if(s.charAt(idxS)==t.charAt(idxT)) {
    //         return helper(s,t,++idxS,++idxT);
    //     }else{
    //         return helper(s,t,idxS,++idxT);
    //     }
    // }


    //iterative
    public boolean isSubsequence(String s, String t) {
        int idxS=0;
        int idxT=0;
    
        while(idxS<s.length() && idxT<t.length()){
        if(s.charAt(idxS)==t.charAt(idxT)){
               idxS++;
        }
        idxT++;
        }
        return idxS==s.length();
    }
    
}