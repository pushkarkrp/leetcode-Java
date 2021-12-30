class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        if(s.length() % 2 == 1) return false;
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
                continue;
            }
            if(st.size() == 0) return false;
            char top = st.pop();
            if((top == '(' && ch != ')') || (top == '{' && ch != '}') || (top == '[' && ch != ']')) {
                return false;
            }
        }
        if(st.size() > 0) return false;
        return true;
    }
}