class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int insertions = 0;

        for (int i = 0;i < s.length();i++){
            char ch = s.charAt(i);

            if (ch == '(') st.push(ch);
            else{
                if (!st.isEmpty() && st.peek() == '('){
                    if (i < s.length() - 1 && s.charAt(i + 1) == ')') i++;
                    else insertions++;
                    st.pop();
                }
                else{
                    if (i < s.length() - 1 && s.charAt(i + 1) == ')'){
                        insertions++;
                        i++;
                    }
                    else insertions += 2;
                }
            }
        }

        while (!st.isEmpty()){
            if (st.peek() == '('){
                insertions += 2;
                st.pop();
            }
            else{
                st.pop();
                if (!st.isEmpty()) insertions++;
                else insertions += 2;
            }
        }

        return insertions;
    }
}