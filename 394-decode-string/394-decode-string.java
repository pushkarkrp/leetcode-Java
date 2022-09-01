class Solution {
    public static String decodeString(String s) {
        int index = 0 , digit = 0;
        String decode = "";
        Stack<String> st = new Stack<>();
        while (index < s.length()) {
            if (s.charAt(index) == ']') {
                int counter = Integer.parseInt(st.pop());
                String temp = st.pop();
                for (int i = 0;  i<counter; i++) {
                    temp += decode;
                }
                decode = temp;
            }
            else if (s.charAt(index) == '[') {
                st.push(decode);
                st.push(String.valueOf(digit));
                digit = 0;
                decode = "";
            }
            else if (Character.isDigit(s.charAt(index))) {
                digit = 10*digit + s.charAt(index) - '0';
            }
            else {
                decode += s.charAt(index);
            }
            index++;
        }
        return decode;
    }
}