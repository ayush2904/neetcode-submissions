class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        gen(0,0,"",n,ans);
        return ans;
    }

    public void gen(int ob, int b, String s, int n, List<String> ans) {
      //  System.out.println(ob+" "+b+" "+s+" "+n+" "+ans);
       if(ob<n && b>0) {
         gen(ob+1,b+1,s+"(",n,ans);
         gen(ob,b-1,s+")",n,ans);
       }
       else if(ob<n && b==0) {
        gen(ob+1,b+1,s+"(",n,ans);
       }
       else if(ob==n && b>0) {
        gen(ob,b-1,s+")",n,ans);
       }
       else if (ob==n && b==0 && s.length() == 2*n){
       ans.add(s);
       } 
       else {
        return;
       }
    }
}
