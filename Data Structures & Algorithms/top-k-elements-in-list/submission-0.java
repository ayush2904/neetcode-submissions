class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer, Integer> > list =
               new LinkedList<Map.Entry<Integer, Integer> >(map.entrySet());
        
         Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1, 
                               Map.Entry<Integer, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        int[] ka = new int[k];
        for (Map.Entry<Integer, Integer> aa : list) {
           ka[--k] = aa.getKey();
           if(k==0) break;
        }

        return ka;
    }
}
