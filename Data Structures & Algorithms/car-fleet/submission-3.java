class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        car[] cars = new car[position.length];
        for(int i=0; i<position.length; i++) {
            cars[i] = new car(position[i], (double)(target - position[i])/speed[i]);
        }
        Arrays.sort(cars,(o1,o2)-> o1.pos - o2.pos);
        
        for(int i=0; i<cars.length; i++) {
            System.out.println(cars[i].pos +" "+cars[i].spd);
        }
        
        int t = position.length;
        int ans = 0;
        while(--t > 0) {
            if(cars[t].spd < cars[t-1].spd) {
            ans++;
            } else {
                cars[t-1] = cars[t];
            }
        }
        
        return ans+1;
    }

    public class car {
        int pos;
        double spd;

        public car(int pos, double spd) {
            this.pos = pos;
            this.spd = spd;
        }
    }
}
