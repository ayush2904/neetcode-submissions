class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i=0;i<heights.length;i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int idx = stack.pop();
                int height = heights[idx];

                int width; 
                if(!stack.isEmpty()) width = i - stack.peek()-1; 
                else width = i;

                int currentArea = height * width;
                max = Math.max(currentArea,max);
            }
            stack.push(i);
        }
        

        ///System.out.println(stack);
        
        while(!stack.isEmpty()) {
          int idx = stack.pop();
          int height = heights[idx];
          int width; 
          if(!stack.isEmpty()) width = (heights.length - stack.peek()-1); 
          else width = heights.length;

          int currentArea = height * width;
          max = Math.max(currentArea,max);
        }

        return max;
    }
}