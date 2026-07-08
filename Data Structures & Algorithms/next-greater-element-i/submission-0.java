class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<nums1.length;i++) {
            map.put(nums1[i],i);
        }

        Stack<Integer> stack = new Stack<Integer>();
        int[] ans = new int[nums1.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<nums2.length;i++) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                ans[map.get(stack.peek())]=nums2[i];
                stack.pop();
            }
            if(map.containsKey(nums2[i])) stack.push(nums2[i]);
        }
        return ans;
    }
}