class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> gAnagrams = new HashMap<>();

        for(String s : strs) {
            char[] akey = s.toCharArray();
            Arrays.sort(akey);
            String key = new String(akey);
            if(gAnagrams.containsKey(key)) {
                List<String> temp = gAnagrams.get(key);
                temp.add(s);
               // gAnagrams.put(key,temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                gAnagrams.put(key,temp);
            }
        }
        //System.out.print(gAnagrams);
        List<List<String>> f = new ArrayList<List<String>>();
        for(Map.Entry<String,List<String>> entry : gAnagrams.entrySet()){
            f.add(entry.getValue());
        }
        return f;
    } 
}
