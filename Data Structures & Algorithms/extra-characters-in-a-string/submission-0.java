class Solution {
    TrieNode root = new TrieNode(new TrieNode[26], false);

    public int minExtraChar(String s, String[] dictionary) {
        HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
        createPrefixTree(dictionary);
        dp.put(s.length(), 0);
        return traverse(0, s, dp);
    }

    public int traverse(int idx, String s, HashMap<Integer, Integer> dp) {
        //System.out.println(s+" | "+word);
        if (dp.containsKey(idx))
            return dp.get(idx);

        int res = 1 + traverse(idx + 1, s, dp);

        TrieNode current = root;

        for (int i = idx; i < s.length(); i++) {
            TrieNode[] children = current.children;
            if (children[s.charAt(i) - 'a'] != null) {
                current = children[s.charAt(i) - 'a'];
            } else {
                break;
            }
            if (current.isWord) {
            res = Math.min(res, traverse(1 + i, s, dp));
            }
        }

        dp.put(idx, res);
        return res;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode(TrieNode[] children, boolean isWord) {
            this.children = children;
            this.isWord = isWord;
        }
    }

    /**
       
    */

    public void createPrefixTree(String[] words) {
        for (String word : words) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode[] currentChildren = current.children;
                TrieNode newNode = new TrieNode(new TrieNode[26], false);
                if (currentChildren[word.charAt(i) - 'a'] != null) {
                    newNode = currentChildren[word.charAt(i) - 'a'];
                }
                currentChildren[word.charAt(i) - 'a'] = newNode;
                current = newNode;
            }
            current.isWord = true;
        }
    }
}