class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ltr = new int[nums.length];
        int[] rtl = new int[nums.length];
        ltr[0] = 1;
        for(int i=1; i<nums.length; i++) {
          ltr[i] = nums[i-1]*ltr[i-1];
        }
        rtl[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--) {
          rtl[i] = nums[i+1]*rtl[i+1];
        }
        
    /*    for(int i=0; i<nums.length; i++){
            System.out.print(ltr[i]+ " ");
        }
        System.out.println();
        for(int i=0; i<nums.length; i++){
            System.out.print(rtl[i]+ " ");
        } */

        int[] ans = new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
        ans[i] = (ltr[i]) * (rtl[i]);
        }
    return ans;
    }
}  
