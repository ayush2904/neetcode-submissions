class LFUCache {

    HashMap<Integer, Integer> freq;
    HashMap<Integer, Integer> cache;
    HashMap<Integer, LinkedHashSet<Integer>> freqMap;
    int capacity;
    int minKey;

    public LFUCache(int capacity) {
        this.freq = new HashMap<Integer, Integer>(capacity);
        this.cache = new HashMap<Integer, Integer>(capacity);
        this.freqMap = new HashMap<Integer, LinkedHashSet<Integer>>();
        this.capacity = capacity;
        this.minKey = Integer.MAX_VALUE;
    }

    public int get(int key) {
        int value = cache.getOrDefault(key, -1);
        if (value != -1) {
            updateFreq(key);
        }
        return value;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (cache.size() == capacity) {
               deleteKey();
            }
        }
        updateFreq(key);
        cache.put(key, value);
    }

    public void updateFreq(int key) {
        //System.out.println("freq : " + freq+ " "+ key);
        //System.out.println("freqMap : " + freqMap);
        //System.out.println("cache : " + cache);
        
        int o = freq.containsKey(key) ? freq.get(key) : 0;
        int n = o + 1;

        if (o != 0) {
            freqMap.get(o).remove(key);
            if (freqMap.get(o).size() == 0) {
                freqMap.remove(o);
                if (minKey == o) {
                    minKey++;
                }
            }
        }

        LinkedHashSet<Integer> list = freqMap.getOrDefault(n, new LinkedHashSet<Integer>());
        list.add(key);
        freqMap.put(n, list);
        freq.put(key, n);
        minKey = Math.min(minKey, n);
    }

    public void deleteKey() {
        LinkedHashSet<Integer> lfSet = freqMap.get(minKey);
        int dk = lfSet.iterator().next();
        freq.remove(dk);
        cache.remove(dk);
        if (lfSet.size() == 0) {
            freqMap.remove(minKey);
        } else
            freqMap.get(minKey).remove(dk);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */