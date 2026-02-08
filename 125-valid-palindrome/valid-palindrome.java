class Solution {
    public boolean isPalindrome(String s) {
        String cleanedString="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='A' && c<='Z') cleanedString+=Character.toLowerCase(c);
            if(c>='a' && c<='z') cleanedString+=c;
            if(c>='0' && c<='9') cleanedString+=c;
        }
        return cleanedString.equals(new StringBuilder(cleanedString).reverse().toString());
    }
}