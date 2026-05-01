class Solution {
    public int findMin(int[] nums) {
        int l =0;
        int r =nums.length-1;
        int ans =nums[0];
        while(l<=r) {
        int mid = (l+r)/2;
        if(nums[l]<=nums[r]) {
           ans = Math.min(nums[l],ans);
           break;
        }
        ans=Math.min(nums[mid],ans);
        if((nums[l]<=nums[mid])) {
          //System.out.println("a-d"+" "+nums[mid]);
           l=mid+1;
        } else {
          //System.out.println("d-a"+" "+nums[mid]);
           r=mid-1;
        }
      }
      return ans;
    }
}
