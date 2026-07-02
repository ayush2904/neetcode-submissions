class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();

        for(int num : asteroids) {
            boolean isBoth = false;
            while((!stack.isEmpty() && ((stack.peek()>0 && num<0))) && (!stack.isEmpty() && (Math.abs(stack.peek()) <= Math.abs(num)))) { 
                if(Math.abs(stack.pop()) == Math.abs(num)) {
                   isBoth = true;
                   break;
                }        
            } 
          
           if(isBoth || ((!stack.isEmpty() && ((stack.peek()>0 && num<0))) && (!stack.isEmpty() && Math.abs(stack.peek()) > Math.abs(num)))) {
              continue;
           }
        //System.out.println(stack); 
        stack.push(num);
        }

        int[] ans = new int[stack.size()];

        for(int i=ans.length-1;i>=0;i--) {
            ans[i]=stack.pop();
        }

        return ans;
    }
}