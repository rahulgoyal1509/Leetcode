class Solution {
    List<String> ans = new ArrayList<>();

    void generate(int n, int open, int close, StringBuilder sb){
        if (sb.length() == 2 * n){
            ans.add(sb.toString());
            return;
        }

        if (open < n){
            sb.append('(');
            generate(n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open){
            sb.append(')');
            generate(n, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, new StringBuilder());
        return ans;
    }
}