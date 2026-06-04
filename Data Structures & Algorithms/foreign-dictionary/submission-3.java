class Solution {
    HashMap<Character, Set<Character>> adjList = new HashMap<Character, Set<Character>>();
    Set<Character> all = new HashSet<Character>();
    Set<Character> cycle = new HashSet<Character>();
    Set<Character> visited = new HashSet<Character>();
    StringBuffer ans = new StringBuffer();

    public String foreignDictionary(String[] words) {
      if(words.length == 1) return words[0];

      for(int i=1;i<words.length;i++) {
        String word1 = words[i-1];
        String word2 = words[i];
        int j=0;
        for(;j<Math.min(word1.length(),word2.length());j++) {
            if(word1.charAt(j)!=word2.charAt(j)) {
                Set<Character> set = adjList.getOrDefault(word1.charAt(j), new HashSet<Character>());
                set.add(word2.charAt(j));
                adjList.put(word1.charAt(j),set);
                break;
            }
        }
        //prefix case;
        if(j==word2.length() && word1.length()>word2.length()) {
            return "";
        }

        for(int k=0;k<word1.length();k++) {
            all.add(word1.charAt(k));
        }

        for(int k=0;k<word2.length();k++) {
            all.add(word2.charAt(k));
        }
      }
      
      for(Character c : all) {
        //cycle.clear();
        if(!dfs(c)) return "";
      }

      return ans.toString();
    }

    public boolean dfs(char c) {
        if(cycle.contains(c)) {
            return false;
        } 

        if(visited.contains(c)) {
            return true;
        }
        cycle.add(c);
        Set<Character> set = adjList.get(c);

        if(set!=null) {
            for(char n : set) {
                if(visited.contains(n)) continue;
                if(!dfs(n)) return false;
            }
        }
        visited.add(c);
        cycle.remove(c);
        ans.insert(0,c);
        return true;
    }
}
