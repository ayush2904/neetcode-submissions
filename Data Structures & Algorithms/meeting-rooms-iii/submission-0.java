class Solution {
    public int mostBooked(int n, int[][] meetings) {

        List<meeting> meets = new ArrayList<>();

        for (int[] m : meetings) {
            meets.add(new meeting(m[0], m[1] - m[0]));
        }

        Collections.sort(meets,
                (a, b) -> Integer.compare(a.startTime, b.startTime));

        // Free rooms (smallest id first)
        PriorityQueue<room> availableRooms = new PriorityQueue<room>((a,b)-> Integer.compare(a.id,b.id));

        for (int i = 0; i < n; i++) {
            availableRooms.offer(new room(i));
        }

        // Busy rooms (earliest finish time, then room id)
        PriorityQueue<room> busyRooms = new PriorityQueue<>((a, b) -> {
            if (a.nextFreeAt != b.nextFreeAt)
                return Long.compare(a.nextFreeAt, b.nextFreeAt);

            return Integer.compare(a.id, b.id);
        });

        HashMap<Integer, Integer> roomsMeet = new HashMap<>();

        int max = 0;
        int ans = 0;

        for (meeting m : meets) {

            // Free every room available before this meeting starts
            while (!busyRooms.isEmpty()
                    && busyRooms.peek().nextFreeAt <= m.startTime) {

                availableRooms.offer(busyRooms.poll());
            }

            room r;

            if (!availableRooms.isEmpty()) {

                int roomId = availableRooms.poll().id;
                r = new room(roomId);
                r.nextFreeAt = (long) m.startTime + m.duration;

            } else {

                r = busyRooms.poll();
                r.nextFreeAt += m.duration;
            }

            busyRooms.offer(r);

            int count = roomsMeet.getOrDefault(r.id, 0) + 1;
            roomsMeet.put(r.id, count);

            if (count > max) {
                max = count;
                ans = r.id;
            } else if (count == max) {
                ans = Math.min(ans, r.id);
            }
        }

        return ans;
    }

    static class room {
        long nextFreeAt;
        int id;

        room(int id) {
            this.id = id;
        }
    }

    static class meeting {
        int startTime;
        int duration;

        meeting(int startTime, int duration) {
            this.startTime = startTime;
            this.duration = duration;
        }
    }
}