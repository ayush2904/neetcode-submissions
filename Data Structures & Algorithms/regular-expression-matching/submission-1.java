class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return backTracking(s, p, 0, 0, dp);
    }

    public boolean backTracking(String s, String p, int si, int pi, Boolean[][] dp) {
        if(pi>=p.length() && si>=s.length()) return true;

        if(dp[si][pi]!=null) return dp[si][pi]; 

        boolean firstMatch = false;

        if((si<s.length() && pi<p.length()) && (s.charAt(si)==p.charAt(pi) || p.charAt(pi)=='.')) {
            firstMatch=true;
        }

        if(pi<p.length()-1 && p.charAt(pi+1) == '*') {
            dp[si][pi] = backTracking( s,  p,  si,  pi+2, dp) || (firstMatch && backTracking( s,  p,  si+1,  pi, dp));
            return dp[si][pi];
        }
        
        dp[si][pi] = firstMatch && backTracking( s,  p,  si+1,  pi+1, dp); 
        return dp[si][pi];
    }
}