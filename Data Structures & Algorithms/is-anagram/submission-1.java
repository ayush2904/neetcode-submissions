class Solution {
    public boolean isAnagram(String s, String t) {
    int alpha[] = new int[26];
    if(s.length() != t.length()) return false;
    for(int i = 0; i< s.length(); i++) {
      alpha[s.charAt(i) - 97] = ++alpha[s.charAt(i) - 97];
      alpha[t.charAt(i) - 97] = --alpha[t.charAt(i) - 97];
    }

    for(int i = 0; i<alpha.length; i++ ){
        if(alpha[i]>0) return false;
    }
    return true;
    }
}
