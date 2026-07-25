class Solution {
    public int swimInWater(int[][] grid) {
        /*
        0 3 6
        5 4 2
        8 7 1

        { 4 , 5 , 6, 2, 7, 1}
        */

        int t=0;
        Set<Integer> visited = new HashSet<Integer>();
        PriorityQueue<Swim> pq = new PriorityQueue<Swim>((o1,o2)->Integer.compare(o1.e,o2.e));
        int n = grid.length;
        Swim curr = new Swim(0,0,grid[0][0]);
        addReachables(pq, curr, grid,visited);
        pq.offer(curr);
        t = grid[0][0];

        while(!pq.isEmpty()) {
            curr = pq.poll();
            if(curr.r==n-1 && curr.c==n-1) {
                return t;
            }
            addReachables(pq, curr, grid,visited);

            while(!pq.isEmpty() && pq.peek().e<=t) {
                Swim s = pq.poll();
                addReachables(pq, s, grid,visited);

                if(s.r==n-1 && s.c==n-1) {
                   return t;
                }
            }

            if(!pq.isEmpty()) t=pq.peek().e;
        }

        return -1;
    }

    public void addReachables(PriorityQueue<Swim> pq, Swim s, int[][] grid, Set<Integer> visited) {
        int r = s.r;
        int c = s.c;
        int R = grid.length;
        int C = R;

        if(!(r+1>=R) && visited.add(grid[r+1][c]))
        pq.offer(new Swim(r+1,c,grid[r+1][c]));

        if(!(r-1<0) && visited.add(grid[r-1][c]))
        pq.offer(new Swim(r-1,c,grid[r-1][c]));

        if(!(c+1>=R) &&visited.add(grid[r][c+1]))
        pq.offer(new Swim(r,c+1,grid[r][c+1]));

        if(!(c-1<0) &&visited.add(grid[r][c-1]))
        pq.offer(new Swim(r,c-1,grid[r][c-1]));
    }
}

class Swim {
    int r;
    int c;
    int e;

    public Swim(int r, int c, int e) {
        this.r = r;
        this.c = c;
        this.e = e;
    }

    /*@Override
    public String toString() {
        return this.r+" "+this.c+" "+this.e;
    }*/
}