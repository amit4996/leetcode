class Solution {

    //Doing string concatenation inside loop is costly as in java strings are immutable so 
    //new string gets created everytime
    // use functions like Character.isLetterOrDigit() && Character.toLowerCase()
    // public boolean isPalindrome(String s) {
    //     String cleanedString="";
    //     for(int i=0;i<s.length();i++){
    //         char c=s.charAt(i);
    //         if(c>='A' && c<='Z') cleanedString+=Character.toLowerCase(c);
    //         if(c>='a' && c<='z') cleanedString+=c;
    //         if(c>='0' && c<='9') cleanedString+=c;
    //     }
    //     return cleanedString.equals(new StringBuilder(cleanedString).reverse().toString());
    // }


   //optimized
   // string created two new string during returning 
    // public boolean isPalindrome(String s) {
    //     StringBuilder cleanedString= new StringBuilder();

    //     for(int i=0;i<s.length();i++){
    //        char c = s.charAt(i);
    //        if(Character.isLetterOrDigit(c)){
    //          cleanedString.append(Character.toLowerCase(c));
    //        }
    //     }

    //     return cleanedString.toString().equals(new StringBuilder(cleanedString).reverse().toString());

    // }

    public boolean isPalindrome(String s) {
        StringBuilder cleanedString= new StringBuilder();

        for(int i=0;i<s.length();i++){
           char c = s.charAt(i);
           if(Character.isLetterOrDigit(c)){
             cleanedString.append(Character.toLowerCase(c));
           }
        }
        
        int start=0;
        int end=cleanedString.length()-1;

        while(start<end){
            if(cleanedString.charAt(start) != cleanedString.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}