class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Edge> edgeList = new ArrayList<Edge>();
        List<Integer> critical = new ArrayList<Integer>();
        List<Integer> pcritical = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            edgeList.add(new Edge(edge[0], edge[1], edge[2], i));
        }

        Collections.sort(edgeList, (a, b) -> Integer.compare(a.w, b.w));

        int ogmst = 0;

        DSU dsu = new DSU(n);

        for (int i = 0; i < edgeList.size(); i++) {
            Edge e = edgeList.get(i);
            if (dsu.union(e.s, e.d)) {
                ogmst += e.w;
            }
        }

        //System.out.println("og :"+ogmst+" "+dsu.maxRank);
        //check for critical 
        for (int i = 0; i < edgeList.size(); i++) {
            dsu.reset(n);
            int currentMst = 0;

            for (int j = 0; j < edgeList.size(); j++) {
                if(i==j) continue;
                Edge e = edgeList.get(j);
                if (dsu.union(e.s, e.d)) {
                    currentMst += e.w;
                }
            }
           // System.out.println("current :"+currentMst+" "+dsu.maxRank);

            if(dsu.maxRank!=n || currentMst > ogmst) {
                critical.add(edgeList.get(i).i);
                continue;
            }

            //check for psudo
            dsu.reset(n);                      
            dsu.union(edgeList.get(i).s, edgeList.get(i).d);
            currentMst = edgeList.get(i).w;
            for (int j = 0; j < edgeList.size(); j++) {
                Edge e = edgeList.get(j);
                if (dsu.union(e.s, e.d)) {
                    currentMst += e.w;
                }
            }

            if(dsu.maxRank == n && currentMst == ogmst) {
                pcritical.add(edgeList.get(i).i);
            }
        }

        ans.add(critical);
        ans.add(pcritical);
        return ans;
    }
}

class Edge {
    int s;
    int d;
    int w;
    int i;

    public Edge(int s, int d, int w, int i) {
        this.s = s;
        this.d = d;
        this.w = w;
        this.i = i;
    }
}

class DSU {
    int[] parent;
    int[] rank;
    int maxRank;

    public DSU(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.maxRank = 1;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.fill(rank,1);
    }

    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py)
            return false;
        if (rank[px] > rank[py]) {
            parent[py] = px;
            rank[px] += rank[py];
            maxRank = Math.max(maxRank, rank[px]);
        } else {
            parent[px] = py;
            rank[py] += rank[px];
            maxRank = Math.max(maxRank, rank[py]);
        }
        return true;
    }
    
    public void reset(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.maxRank = 0;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.fill(rank,1);
    }
}