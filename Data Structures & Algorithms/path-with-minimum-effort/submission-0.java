class Solution {
    public int minimumEffortPath(int[][] heights) {
        /*this matrix can also be seen as graph where every cell is a node and up,down,right,left is edges with weight as absolute difference we will do Djistra on this*/

        int R = heights.length;
        int C = heights[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.w, o2.w));
        pq.offer(new Node(0, 0, 0));
        int[][] dist = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();

            int r = currNode.r;
            int c = currNode.c;
            int w = currNode.w;

            if (w > dist[r][c]) {
                continue;
            }

            if (r == R - 1 && c == C - 1)
                return w;

            //add neibhors
            if (!(r - 1 >= R || r - 1 < 0 || c >= C || c < 0)) {
                int cw = Math.abs(heights[r - 1][c] - heights[r][c]);
                int nw = Math.max(w, cw);
                if (nw < dist[r - 1][c]) {
                    dist[r - 1][c]=nw;
                    pq.offer(new Node(nw, r - 1, c));
                }
            }

            if (!(r + 1 >= R || r + 1 < 0 || c >= C || c < 0)) {
                int cw = Math.abs(heights[r + 1][c] - heights[r][c]);
                int nw = Math.max(w, cw);
                if (nw < dist[r + 1][c]) {
                    dist[r + 1][c] = nw;
                    pq.offer(new Node(nw, r + 1, c));
                }
            }

            if (!(r >= R || r < 0 || c + 1 >= C || c + 1 < 0)) {
                int cw = Math.abs(heights[r][c + 1] - heights[r][c]);
                int nw = Math.max(w, cw);
                if (nw < dist[r][c + 1]) {
                    dist[r][c + 1] = nw;
                    pq.offer(new Node(nw, r, c + 1));
                }
            }

            if (!(r >= R || r < 0 || c - 1 >= C || c - 1 < 0)) {
                int cw = Math.abs(heights[r][c - 1] - heights[r][c]);
                int nw = Math.max(w, cw);
                if (nw < dist[r][c - 1]) {
                    dist[r][c - 1]=nw;
                    pq.offer(new Node(nw, r, c - 1));
                }
            }

            //System.out.println("for " + currNode + " - " + pq);
        }
        return 0;
    }

    static class Node {
        int r;
        int c;
        int w;

        public Node(int w, int r, int c) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

       /* @Override
        public String toString() {
            return this.w + " - " + this.r + " - " + this.c;
        }*/
    }
}