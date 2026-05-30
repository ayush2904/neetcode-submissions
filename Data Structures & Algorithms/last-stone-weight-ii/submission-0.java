class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for(int i : stones) {
            totalSum+=i;
        }

        int[][] dp = new int[stones.length+1][totalSum+1];
        
        for(int[] d : dp)
        Arrays.fill(d,-1);

        return dfs(stones,0,totalSum,0,dp);
    }

    public int dfs(int[] stones, int idx, int totalSum, int sum, int[][] dp) {
        if(idx>=stones.length) {
            int sumb = totalSum-sum;
            dp[idx][sum] = Math.abs(sum-sumb);
            return dp[idx][sum];
        }

        if(dp[idx][sum]!=-1) return dp[idx][sum];

        dp[idx][sum] = Math.min(dfs(stones,idx+1,totalSum,stones[idx]+sum,dp), dfs(stones,idx+1,totalSum,sum,dp));
        return dp[idx][sum];
    }
}