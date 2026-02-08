class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        if(n<=0) return "";
        String pick=strs[0];
        int idx=0;
        StringBuilder prefix=new StringBuilder();
        while(idx<pick.length()){
            char c=pick.charAt(idx);
            for(int i=1;i<n;i++){
                if(idx>=strs[i].length() || strs[i].charAt(idx)!=c) 
                {
                    return prefix.toString();
                }
            }
             prefix.append(c);
            idx++;
        }

        return prefix.toString();
    }
}