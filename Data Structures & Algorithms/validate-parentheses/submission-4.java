class Solution {
    public boolean isValid(String s) {
        stack<Character> st = new stack<Character>(s.length());

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
            st.push(s.charAt(i));
            else {
                if(!st.isEmpty()) {
                if(s.charAt(i)=='}' && st.top() == '{') {
                    st.pop();
                    continue;
                }
                if(s.charAt(i)==')' && st.top() == '(') {
                    st.pop();
                    continue;
                }
                if(s.charAt(i)==']' && st.top() == '[') {
                    st.pop();
                    continue;
                }
                }
                return false;                
            }
        }
        return st.isEmpty() && true;
    }

    public static class stack<T> {
        private int top = 0;
        private List<T> stackds;

        public stack(int size) {
            stackds = new ArrayList<T>(size);
        }

        public T push(T val) {
            stackds.add(val);
            top++;
            return val;
        }

        public T pop() {
            T rItem = stackds.get(top-1);
            stackds.remove(top-1);
            top--;
            return rItem;
        }

        public T top() {
            if(top <= 0) return null;
            return stackds.get(top-1);
        }

        public boolean isEmpty() {
            if(stackds.size()<=0) return true;
            return false;
        }
    } 
}

