class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] dp = new Integer[n];

        int ans = dfs(stoneValue,0,dp);
        if(ans==0) return "Tie";
        return ans>0 ? "Alice" : "Bob";
    }

    public int dfs(int[] stones, int left, Integer[] dp) {
        if(left>=stones.length) return 0;
        if(dp[left]!=null) return dp[left];

        int currentWeight = 0;
        int max = Integer.MIN_VALUE;
        for(int i=left; i<Math.min(left+3, stones.length);i++) {
            currentWeight = currentWeight+stones[i];  
            int r = currentWeight-dfs(stones,i+1,dp);
            //System.out.println(r+" --- "+stones[i]);
            max = Math.max(max, r);
        }
        dp[left] = max==Integer.MIN_VALUE ? 0:max;
        return dp[left];
    }
}