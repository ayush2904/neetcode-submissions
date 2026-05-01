class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> sq = new HashSet<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
        sq.add(nums[i]);
        }
        for(int n : nums) {
            int count = 0;
            while(sq.contains(n++)) {
            count++;
            if(count>ans) ans = count;
            }
        }
        return ans;
    }
}
