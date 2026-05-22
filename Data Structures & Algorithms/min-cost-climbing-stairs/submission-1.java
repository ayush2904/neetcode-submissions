class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        if(n==1){
            return cost[0];
        }
        if(n==2){
            return Math.min(cost[0],cost[1]);
        }

        int[] dp = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp,-1);
        //Arrays.fill(dp2,-1);
        return Math.min(dfs(0,cost,dp),dfs(1,cost,dp));
    }

    public int dfs(int i, int[] cost,int[] dp) {
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];

        int c = cost[i] + Math.min(dfs(i+1,cost,dp), dfs(i+2,cost,dp));
        dp[i]=c;
        return c;
    }
}