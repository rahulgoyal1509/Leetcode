class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int val = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(val);
                val = 0;
            } 
            else {
                int prev = st.pop();

                if (val == 0) val = 1;
                else val *= 2;

                val += prev;
            }
        }

        return val;
    }
}