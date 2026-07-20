class Solution {
    List<String> ans = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adjMap = new HashMap<String, PriorityQueue<String>>();
        
        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            PriorityQueue<String> list = adjMap.getOrDefault(from, new PriorityQueue<String>());
            list.offer(to);
            adjMap.put(from,list);
        }
        
        dfs("JFK", adjMap);
        return ans;
    }

    public void dfs(String station, HashMap<String, PriorityQueue<String>> adjMap) {
      if(!adjMap.containsKey(station)) {
        ans.addFirst(station);
        return;
      }

      PriorityQueue<String> pq = adjMap.get(station);

      while(!pq.isEmpty()) {
        dfs(pq.poll(),adjMap);
      }

      ans.addFirst(station);
    }
}
