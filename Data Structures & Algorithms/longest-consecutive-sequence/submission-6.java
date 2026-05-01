class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> sq = new HashSet<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
        sq.add(nums[i]);
        }

        for(int num : nums) {
            int n = num;
            int count = 0;
            //System.out.println (k + " -- "+ count);
            if(!sq.contains(num-1)) {
            while(sq.contains(n++)) {
            count++;
            if(count>ans) ans = count;
            //System.out.println (n + " --- "+ count);
            }
            }
        }
        return ans;
    }
}
