class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> st = new Stack<Integer>();
        int[] ans = new int[t.length];

        for(int i=0; i<t.length; i++) {
            if(st.isEmpty()) {
                st.push(i);
            } else {
            while(!st.isEmpty() && t[st.peek()] < t[i]) {
                ans[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
            }
        }
        return ans;
    }
}
