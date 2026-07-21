class Solution {
    public int stoneGameII(int[] piles) {
       /*
       x+y = 26
       x-y = -6
       x=-6-y
       -6+y+y= 26
       2y=26
       y=10
       */
       if(piles.length==1) return piles[0];
       int total = 0;
       Integer[][] dp = new Integer[piles.length][piles.length];
       for(int i=0;i<piles.length;i++) {
        total+=piles[i];
       }
       int diff = dfs(piles, 1, 0,dp);
       int ans = (total+diff)/2;
       return ans;
    }

    public int dfs(int[] piles, int M, int curr, Integer[][] dp) {
        if(curr>=piles.length) return 0;
        if(dp[curr][M]!=null) return dp[curr][M];
        int currWeight = 0;
        int max = Integer.MIN_VALUE;
        for(int i=curr;i<Math.min(piles.length,curr+2*M);i++) { 
          int X = i-curr+1;
          currWeight+=piles[i];
          max = Math.max(max, currWeight-dfs(piles,Math.max(X,M),i+1,dp));
        }

        if(max==Integer.MIN_VALUE) dp[curr][M] = 0;
        dp[curr][M] = max;
        return dp[curr][M];
    }
}