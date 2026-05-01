class MinStack {   
    Stack<Integer> os;
    Stack<Integer> ms;
    public MinStack() {
        this.os = new Stack<>();
        this.ms = new Stack<>();
        int min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        os.push(val);
        int min = (!ms.isEmpty() && val > ms.peek()) ? ms.peek() : val;
        ms.push(min);
    }
    
    public void pop() {
       os.pop();
       ms.pop(); 
    }
    
    public int top() {
        return os.peek();
    }
    
    public int getMin() {
        return ms.peek();
    }
}
