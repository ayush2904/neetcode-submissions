class Solution {
    HashSet<Integer> visited = new HashSet<Integer>();
    HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();

    public int countComponents(int n, int[][] edges) {
    int m = edges.length;
    
    for(int i=0; i<m; i++) {
        int u = edges[i][0];
        int v = edges[i][1];

        List<Integer> tempList = adj.getOrDefault(u,new ArrayList<Integer>());
        tempList.add(v);
        adj.put(u,tempList);
        
        tempList = adj.getOrDefault(v,new ArrayList<Integer>());
        tempList.add(u);
        adj.put(v,tempList);
    }

    int components = 0;
    if(adj.size() > 0 )
    for(int i=0;i<n;i++) {
        if(!visited.contains(i)) {
           dfs(i);
           components++;
        }
    } else return n;

    return components;
    }

    public void dfs(int node) {
        if(visited.contains(node)) return;

        visited.add(node);

        List<Integer> adjList = adj.get(node);
        if(adjList!=null)
        for(int n : adjList) {
            dfs(n);
        }
    }
}
