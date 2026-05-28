class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->Integer.compare(a[0],b[0]));

        for(int i=0;i<intervals.length;i++) {
            pq.offer(intervals[i]);
        }
        
        int ans = 0;
        int[] prevInterval = pq.poll();
        
        while(!pq.isEmpty()) {
            int[] interval = pq.poll();
            int[] newinterval = interval;
            //[1,2],[1,9]
            //
            if(prevInterval[1] > interval[0]) {
               newinterval[0] = Math.min(prevInterval[0],interval[0]);
               newinterval[1] = Math.min(prevInterval[1],interval[1]);
               //pq.offer(newinterval);
               ans++;
            }
            prevInterval = newinterval;
        }

        //System.out.println(pq);
        return ans;
    }
}