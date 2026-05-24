class Solution {
    int offset = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for(int i : nums) {
            sum+=i;
        }

        offset = sum;

        int[][] dp = new int[nums.length][2*sum+1];
        
        for(int i=0;i<nums.length;i++)
            Arrays.fill(dp[i],-1);
        return dfs(nums, target, 0,0, dp);
    }

    public int dfs(int[] nums, int target, int current, int idx, int[][] dp) {
        if(idx==nums.length) {
            if(current==target) {
                return 1;
            }
        return 0;
        }

        if(dp[idx][current+offset] != -1) return dp[idx][current+offset];

        int res = 0;
        //+
        res += dfs(nums,target,current+nums[idx],idx+1, dp);

        res += dfs(nums,target,current-nums[idx],idx+1, dp);

        dp[idx][current+offset] = res;
        return res;
    }  
}