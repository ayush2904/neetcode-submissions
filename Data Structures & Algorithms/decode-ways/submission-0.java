class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return numDecodingsUtill(s,0,dp);
    }

    public int numDecodingsUtill(String s, int idx, int[] dp) {
        if(idx>=s.length()) return 1;
        if(dp[idx]!=-1) return dp[idx];
        int res = 0;

        if(s.charAt(idx)>='1' && s.charAt(idx)<='9') {
            if((idx<(s.length()-1)) 
            && ((s.charAt(idx) == '1' && (s.charAt(idx+1)>='0' && s.charAt(idx+1)<='9')) 
            || (s.charAt(idx) == '2' && (s.charAt(idx+1)>='0' && s.charAt(idx+1)<='6')))) {
                res += numDecodingsUtill(s, idx+2,dp);
            } 
            res += numDecodingsUtill(s, idx+1,dp);
        }

        dp[idx]=res;
        return res;
    }
}