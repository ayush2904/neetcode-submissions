class Solution {
    public boolean isPalindrome(String s) {
       s = s.toLowerCase();
       int left =0;
       int right =s.length()-1;

       while(left < right) {
       if(!(s.charAt(right) >= 'a' && s.charAt(right) <= 'z') && !(s.charAt(right)>='0' && s.charAt(right)<='9')){
        //System.out.println("doing r-- "+s.charAt(right));
        right--;
        continue;
       }
       if(!(s.charAt(left) >= 'a' && s.charAt(left)<='z') && !(s.charAt(left)>='0' && s.charAt(left)<='9')){
       // System.out.println("doing l++ "+s.charAt(left));
        left++;
        continue;
       }    
       //System.out.println("compairing l r "+s.charAt(left)+" "+s.charAt(right)+" "+left+" "+right);
       if(s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
        continue;
       } else 
       return false;
       }
       return true;
    }
}
