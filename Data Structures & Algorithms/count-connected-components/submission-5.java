class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            if(dsu.union(a,b)) n--;
        }
        
        return n;
    }
}

class DSU {
    int[] parent;
    int[] rank;
    
    public DSU (int n) {
        this.parent = new int[n];
        this.rank = new int[n];

        for(int i=0;i<n;i++) {
            parent[i]=i;
        }
    }

    public int find(int n) {
        if(parent[n]!=n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if(px==py) return false;

        if(rank[px]>rank[py]) {
            parent[py] = px;
        } else if (rank[py] > rank[px]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }

        return true;
    }
}
