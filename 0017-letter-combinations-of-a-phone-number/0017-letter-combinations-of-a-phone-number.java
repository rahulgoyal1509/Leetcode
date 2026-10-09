class Solution {
    List<String> result = new ArrayList<>();

    void combination(String digits, String[] map, int index, StringBuilder sb){
        if (sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }

        char ch = digits.charAt(index);
        String str = map[ch - '0'];

        for (int i = 0;i < str.length();i++){
            sb.append(str.charAt(i));

            combination(digits, map, index + 1, sb);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        combination(digits, map, 0, new StringBuilder());

        return result;
    }
}