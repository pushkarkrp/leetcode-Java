class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push('(');
            } else if(ch == ')') {
                stack.pop();
            }
            ans = Math.max(ans, stack.size());
        }
        return ans;
    }
}