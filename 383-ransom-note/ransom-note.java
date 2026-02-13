class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> mp = new HashMap<>();
        for(char c:magazine.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        System.out.println(mp);

        for(char c:ransomNote.toCharArray()){
            System.out.println(mp);
            if(mp.get(c)==null || mp.get(c)==0){
                return false;
            }else{
                mp.put(c,mp.get(c)-1);
            }
        }

        return true;
    }
}