class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();
        for(int i=0; i<tokens.length; i++) {
        if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))
        {
            if(tokens[i].equals("+")) {
                int b = Integer.parseInt(s.pop());
                int a = Integer.parseInt(s.pop());
                s.push(String.valueOf(a+b));     
            }
            if(tokens[i].equals("-")) {
                int b = Integer.parseInt(s.pop());
                int a = Integer.parseInt(s.pop());
                s.push(String.valueOf(a-b));
            }
            if(tokens[i].equals("*")) {
                int b = Integer.parseInt(s.pop());
                int a = Integer.parseInt(s.pop());
                s.push(String.valueOf(a*b));
            }
            if(tokens[i].equals("/")) {
            int b = Integer.parseInt(s.pop());
            int a = Integer.parseInt(s.pop());
                s.push(String.valueOf(a/b));
            }
        } else {
            s.push(tokens[i]);
        }
        }
        return Integer.parseInt(s.peek());
    }
}
