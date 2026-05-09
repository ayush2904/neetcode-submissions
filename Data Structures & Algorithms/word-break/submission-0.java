class Solution {
    boolean ans = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>();
        HashMap<Integer, Boolean> pass = new HashMap<Integer, Boolean>();
        
        pass.put(s.length(),true);

        for(String word : wordDict) {
            set.add(word);
        }
        return traverse(s,0,set,pass);
       /* for(boolean boo : pass) {
            System.out.print(boo+" ");
        }*/
        //return ans;
    }

    public boolean traverse(String s, int idx, HashSet<String> set, HashMap<Integer, Boolean> pass) {
       if(pass.containsKey(idx)) {
        return pass.get(idx);
       }

       for(int i=idx; i<s.length();i++) {
        String test = s.substring(idx,i+1);
        if(set.contains(test)) {
            if(traverse(s,i+1,set,pass)) {
                pass.put(idx,true);
                return true;
            }
        }
       }
       pass.put(idx,false);
       return false;
    }
}