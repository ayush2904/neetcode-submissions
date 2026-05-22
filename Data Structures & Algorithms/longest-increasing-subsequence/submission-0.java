class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int ans = 1;
        for(int i=1;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    ans=Math.max(ans,dp[i]);
                }
            }
        }

        /*for(int i : dp) {
            System.out.print(i+" ");
        }*/

        return ans;
    }
}