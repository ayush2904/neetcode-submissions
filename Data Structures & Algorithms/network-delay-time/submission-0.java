class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Node>> adjMap = new HashMap<Integer, List<Node>>();
        int max = 0;

        for (int[] time : times) {
            int src = time[0];
            int dst = time[1];
            int t = time[2];

            List<Node> list = adjMap.getOrDefault(src, new ArrayList<Node>());
            list.add(new Node(dst, t));
            adjMap.put(src, list);
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> Integer.compare(a.time, b.time));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new Node(k, 0));

        while (!pq.isEmpty()) {
            Node cNode = pq.poll();
            int currentTime = cNode.time;
            // System.out.println(currentTime);

            if (dist[cNode.id] < currentTime)
                continue;

            List<Node> list = adjMap.get(cNode.id);
            if (list != null) {
                for (Node temp : list) {
                    int newTime = currentTime + temp.time;
                    if (newTime < dist[temp.id]) {
                        dist[temp.id] = newTime;
                        pq.offer(new Node(temp.id, newTime));
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                max = Math.max(dist[i], max);
            }
        }

        return max;
    }
}

class Node {
    int id;
    int time;

    public Node(int id, int time) {
        this.id = id;
        this.time = time;
    }
}
