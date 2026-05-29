class Solution {
    public boolean validTree(int n, int[][] edges) {
         DSU dsu = new DSU(n);

         for(int[] edge : edges) {
            if(!dsu.union(edge[0],edge[1])) {
                return false;
            }
         }
        
        int ans = dsu.find(0);

        for(int i=1;i<n;i++) {
            if(ans!=dsu.find(i)) {
                return false;
            }
        }
        return true;
    }

    static class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0;i<n;i++) {
                parent[i]=i;
            }
        }

        public int find(int n) {
            if(parent[n]!=n) {
                parent[n] = find(parent[n]);
            }
            return parent[n];
        }

        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if(pa==pb) return false;

            if(rank[pa]>rank[pb]) {
                parent[pb] = pa;
            } else if(rank[pb]>rank[pa]) {
                parent[pa] = pb;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }
}
