class Solution {
    public int majorityElement(int[] nums) {
        int vote =0;
        int ans = 0;

        for(int n : nums) {
            if(vote==0) {
                ans = n;
            }

            if(ans == n) {
                vote++;
            } else {
                vote--;
            }
        }
        return ans;
    }
}