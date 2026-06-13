class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> patternMap = new HashMap<String, List<String>>();

        for (String word : wordList) {
            List<String> patterns = getPatterns(word);
            for (String pattern : patterns) {
                List<String> currentWords = patternMap.getOrDefault(pattern, new ArrayList<String>());
                currentWords.add(word);
                patternMap.put(pattern, currentWords);
            }
        }

        //System.out.println(patternMap);

        int ans = 0;

        //BFS 
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                String p = queue.poll(); 
                if (p.equals(endWord))
                    return ans;
    
                if (!visited.add(p))
                    continue;

                List<String> patterns = getPatterns(p);
                if (patterns != null) {
                    for (String pattern : patterns) {
                        List<String> ws = patternMap.get(pattern);
                        if (ws != null)
                            for (String w : ws) {
                               // System.out.println("pattern - " + pattern + " - " + w);
                                if (!visited.contains(w))
                                    queue.offer(w);
                            }
                    }
                }
            }
        }

        return 0;
    }

    public List<String> getPatterns(String word) {
        List<String> patterns = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            StringBuilder temp = new StringBuilder(word);
            temp.setCharAt(i, '*');
            patterns.add(temp.toString());
        }
        return patterns;
    }
}