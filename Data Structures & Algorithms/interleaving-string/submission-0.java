class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if(s3.length()!=n+m) return false;
        
        Boolean[][] dp = new Boolean[n+1][m+1];
        return dfs(s1,s2,s3,0,0,dp);
    }

    public boolean dfs(String s1, String s2, String s3, int i, int j, Boolean[][] dp) {
        int k = i+j;
        if(dp[i][j]!=null) return dp[i][j];

        if(k==s3.length()) {
             dp[i][j]=true;
             return dp[i][j];
        }

        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)) {
            if(dfs(s1,s2,s3,i+1,j,dp)) {
                dp[i][j] = true;
                return dp[i][j];
            }
        } 
        
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)) {
            dp[i][j] = dfs(s1,s2,s3,i,j+1,dp);
            return dp[i][j];
        } 
        
        dp[i][j] = false;
        return dp[i][j];
    }
}