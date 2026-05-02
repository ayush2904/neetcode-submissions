class Solution {
    HashMap<String,Integer> cache = new HashMap<String,Integer>();
    public int numDistinct(String s, String t) {
        int[][] mem = new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++) {
            Arrays.fill(mem[i],-1);
        }
      return dfs(s,t,0,0,mem);
    }

    public int dfs(String s, String t, int si, int ti,int[][] mem) {
        
        if(ti>=t.length())
           return 1;
        if(si>=s.length()) 
           return 0;
        
        if(mem[si][ti]!=-1) {
            return mem[si][ti];
        }

        if(s.charAt(si)==t.charAt(ti)) {
           mem[si][ti]= dfs(s,t,si+1,ti+1,mem) + dfs(s,t,si+1,ti,mem);
            return mem[si][ti];
        }

        mem[si][ti] = dfs(s,t,si+1,ti,mem);
        return mem[si][ti];
    }
}