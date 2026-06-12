class Solution {
    List<String> ans = new ArrayList<String>();
    TreeNode root = new TreeNode(new TreeNode[26], false);

    public List<String> findWords(char[][] board, String[] words) {

        int R = board.length;
        int C = board[0].length;

        for (String word : words) {
            addWord(word);
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                findWordUtil(board, root, i, j);
            }
        }
        return ans;
    }

    public void findWordUtil(char[][] board, TreeNode currentNode, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || (board[i][j] - 'a') >= 100)
            return;

        currentNode = currentNode.children[board[i][j] - 'a'];

        if (currentNode == null)
            return;

        //currentWord.append(board[i][j]);
        if (currentNode.isWord) {
            ans.add(currentNode.word);
            currentNode.isWord = false;
            //currentWord = new StringBuilder();
        }

        board[i][j] += 100;
        findWordUtil(board, currentNode, i + 1, j);
        findWordUtil(board, currentNode, i - 1, j);
        findWordUtil(board, currentNode, i, j + 1);
        findWordUtil(board, currentNode, i, j - 1);
        board[i][j] -= 100;
        //currentWord.deleteCharAt(currentWord.length() - 1);
    }

    public void addWord(String word) {
        TreeNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            TreeNode newNode = new TreeNode(new TreeNode[26], false);
            if (currentNode.children[word.charAt(i) - 'a'] != null) {
                newNode = currentNode.children[word.charAt(i) - 'a'];
            }
            currentNode.children[word.charAt(i) - 'a'] = newNode;
            currentNode = newNode;
        }
        currentNode.isWord = true;
        currentNode.word = word;
    }

    static class TreeNode {
        TreeNode[] children;
        boolean isWord;
        String word;

        public TreeNode(TreeNode[] children, boolean isWord) {
            this.children = children;
            this.isWord = isWord;
        }
    }
}