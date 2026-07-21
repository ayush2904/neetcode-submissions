class Solution {
    public int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();

        return dfs(nums, target, dp);
    }

    public int dfs(int[] nums, int target, HashMap<Integer, Integer> dp) {
        if(target < 0)
           return 0;
        if(target==0) 
           return 1;
        if(dp.containsKey(target)) return dp.get(target);

        int ways=0;

        for(int num : nums) {
            ways+=dfs(nums, target-num, dp);
        }
        dp.put(target, ways);
        return ways;
    } 
}