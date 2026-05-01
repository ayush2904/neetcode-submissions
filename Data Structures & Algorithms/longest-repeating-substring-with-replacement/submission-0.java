class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int right=0; 
        int[] al = new int[26];
        int d=0;
        int ans = Integer.MIN_VALUE;
        while(right<s.length()) {
            al[s.charAt(right)-65]++;
            if(right-left+1-mfrq(al)>k) {
                while(right-left+1-mfrq(al)>k) {
                    al[s.charAt(left)-65]--;
                    left++;
                }
            }
        ans= Math.max(right-left+1,ans);
        right++;
        }
        return ans;
    }

    public int mfrq(int[] al) {
        int frq=0;
        for(int i=0;i<26;i++) {
            frq= Math.max(frq,al[i]);
        }
        return frq;
    }
}
