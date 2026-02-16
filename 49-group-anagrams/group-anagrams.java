class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> mp = new HashMap<>();

        List<List<String>> result=new ArrayList<>();

        for(int i=0;i<strs.length;i++){
             char[] arr = strs[i].toCharArray();
             Arrays.sort(arr);
             String sorted = new String(arr);
             if(mp.containsKey(sorted)){
                mp.get(sorted).add(strs[i]);
             }else
                {
                    mp.put(sorted,new ArrayList<>());
                    mp.get(sorted).add(strs[i]);
                }
        }

        for(List<String> curr:mp.values()){
            result.add(curr);
        }
        return result;
    }
}