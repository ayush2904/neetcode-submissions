class WordDictionary {
    TrieNode root;
    public WordDictionary() {
      root = new TrieNode('-', new HashMap<Character, TrieNode>());
    }

    public void addWord(String word) {
        Map<Character, TrieNode> rootChild = root.children;
        Map<Character, TrieNode> currentChild = rootChild;

        for(int i=0;i<word.length();i++) {
            char currentChar = word.charAt(i);
            TrieNode currentNode = new TrieNode(currentChar, new HashMap<Character, TrieNode>());
            
            if(currentChild.containsKey(currentChar)) {
             currentNode = currentChild.get(currentChar);
            } else {
                currentChild.put(currentChar, currentNode);
            }

            if(i==word.length()-1) {
                currentNode.isWord = true;
                currentChild.put(currentChar, currentNode);
            }

            currentChild = currentNode.children;
        }
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    public boolean searchHelper(String word, int idx, TrieNode explore) {
        TrieNode currentNode = explore;
        
        for(int i=idx ; i<word.length();i++) {
            char currentChar = word.charAt(i);
            Map<Character, TrieNode> currentChildren = currentNode.children;

            if(currentChar=='.') {
                for(TrieNode child : currentChildren.values()) {
                    if(child != null && searchHelper(word, i+1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if(currentChildren.containsKey(currentChar)) {
                    currentNode = currentChildren.get(currentChar);      
                } else {
                    return false;
                }
            }
        }
       System.out.println(currentNode.c+" "+currentNode.isWord);
       return currentNode.isWord;
    }

    static class TrieNode {
        Character c;
        Map<Character, TrieNode> children;
        boolean isWord = false;

        public TrieNode(Character c, Map<Character, TrieNode> children) {
            this.c= c;
            this.children = children;
        }
    }
}

