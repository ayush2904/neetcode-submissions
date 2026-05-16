class Solution {
    TrieNode root = new TrieNode(new TrieNode[26], false);
   // HashMap<Integer, List<String>> dp = new HashMap<Integer, List<String>>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict) {
            word=word.trim();
            addWord(word);
        }
        
        List<String> ans = new ArrayList<String>();
        traverse(s, 0, new ArrayList<String>(), ans);
        return ans;
    }

    public void traverse(String s, int idx, List<String> words, List<String> ans) {
       /* if(dp.containsKey(idx)) {
            return dp.get(idx);
        }*/

        if(idx>=s.length()) {
            String sentence = "";
            for(int i=0; i<words.size(); i++) {
               String d = i>0 ? " " : "";
               sentence = sentence+d+words.get(i);
            }
            ans.add(sentence);
            return;
        }
        
        TrieNode currentNode = root; 
        for(int i=idx;i<s.length();i++) {
            TrieNode[] currentChildren = currentNode.children;
            char currentChar = s.charAt(i);
            if(currentChildren[currentChar-'a']!=null) {
                currentNode=currentChildren[currentChar-'a'];
            } else {
                break;
            }
            if(currentNode.isWord) {
                String word = s.substring(idx,i+1);
                //System.out.println(word+" is a word");
                words.add(word);
                traverse(s,i+1,words,ans);
                words.remove(words.size()-1);
            }
        }
    }

    public void addWord(String word) {
        TrieNode currentNode = root;

        for(int i=0;i<word.length();i++) {
           char currentChar = word.charAt(i);
           TrieNode[] currentChildren = currentNode.children; 
           if(currentChildren[currentChar-'a']==null) {
               currentNode = new TrieNode(new TrieNode[26], false);
               currentChildren[currentChar-'a'] = currentNode;
           }
           currentNode = currentChildren[currentChar-'a'];
        }
        currentNode.isWord = true;
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode(TrieNode[] children, boolean isWord) {
            this.children = children;
            this.isWord = isWord;
        }
    }
}