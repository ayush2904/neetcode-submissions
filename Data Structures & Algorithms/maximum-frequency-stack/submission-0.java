class FreqStack {
    HashMap<Integer, Integer> freqMap;
    HashMap<Integer, Stack<Integer>> freqSortedMap;
    int maxFreq = 0;

    public FreqStack() {
        freqMap = new HashMap<Integer, Integer>();
        freqSortedMap = new HashMap<Integer, Stack<Integer>>();
    }

    public void push(int val) {
        //get the frequency 
        if (freqMap.containsKey(val)) {
            int of = freqMap.get(val);
            int nf = of + 1;

            maxFreq = Math.max(nf,maxFreq);
            //add to new freq;

            Stack<Integer> l = freqSortedMap.getOrDefault(nf, new Stack<Integer>());
            l.push(val);

            freqSortedMap.put(nf, l);
            freqMap.put(val, nf);
        } else {
            Stack<Integer> l2 = freqSortedMap.getOrDefault(1, new Stack<Integer>());
            l2.push(val);
            maxFreq = Math.max(1,maxFreq);
            freqSortedMap.put(1, l2);
            freqMap.put(val, 1);
        }
        //System.out.println("PUSH : "+val+" mf : "+maxFreq);
        //System.out.println(freqMap);
        //System.out.println(freqSortedMap);
    }

    public int pop() {
        if (freqSortedMap.size() > 0) {
            int lastKey = maxFreq;
            Stack<Integer> lhs = freqSortedMap.get(lastKey);
            int val = lhs.pop();

            int of = freqMap.get(val);
            int nf = of - 1;

        
            if(lhs.size()<=0) {
                freqSortedMap.remove(of);
                maxFreq--;
            }
            
            if(nf>0)
            freqMap.put(val,nf);
            else {
            freqMap.remove(val);
            }
           // System.out.println("POP : "+val+" mf : "+maxFreq);
           // System.out.println(freqMap);
           // System.out.println(freqSortedMap);
            return val;
        }
        return -1;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */