class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0;i < s.length();i++){
            char ch = s.charAt(i);

            if (ch == '('){
                st.push(ch);
                if (st.size() > 1) sb.append('(');
            }
            else{
                if (st.size() > 1) sb.append(')');
                st.pop();
            }
        }

        return sb.toString();
    }
}