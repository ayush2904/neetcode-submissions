class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> projects = new PriorityQueue<Project>((a, b) -> Integer.compare(a.capital, b.capital));

        PriorityQueue<Project> pft = new PriorityQueue<Project>((a, b) -> Integer.compare(b.profit, a.profit));

        for (int i = 0; i < profits.length; i++) {
            projects.offer(new Project(profits[i], capital[i]));
        }

        while (!projects.isEmpty() && projects.peek().capital <= w) {
            pft.offer(projects.poll());
        }

        int ans = 0;

        while (k > 0 && !pft.isEmpty()) {
            Project curr = pft.poll();
            w = w + curr.profit;
            //ans = ans + curr.profit;
            while (!projects.isEmpty() && projects.peek().capital <= w) {
                pft.offer(projects.poll());
            }
            k--;
        }
        return w;
    }

    static class Project {
        int profit;
        int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}