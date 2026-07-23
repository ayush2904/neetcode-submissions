class Solution {
    public int maxProduct(int[] nums) {
        int cmax = 1;
        int cmin = 1;
        int max = nums[0];
        for(int i=0;i<nums.length;i++) {
            int temp = cmax * nums[i];
            cmax = Math.max(Math.max(temp, cmin*nums[i]),nums[i]);
            cmin = Math.min(Math.min(temp, cmin*nums[i]),nums[i]);
            max = Math.max(max,cmax);
        }
        return max;
    }
}
