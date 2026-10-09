class Solution {
    List<String> result = new ArrayList<>();

    void permutation(StringBuilder sb, int index){
        if (index >= sb.length()){
            result.add(sb.toString());
            return;
        }

        char ch = sb.charAt(index);

        if (!(ch >= '0' && ch <= '9')){
            sb.setCharAt(index, Character.toUpperCase(sb.charAt(index)));

            permutation(sb, index + 1);

            sb.setCharAt(index, Character.toLowerCase(sb.charAt(index)));

            permutation(sb, index + 1);
        }
        else{
            permutation(sb, index + 1);
        }
    }

    public List<String> letterCasePermutation(String s) {
        StringBuilder sb = new StringBuilder(s);

        permutation(sb, 0);

        return result;
    }
}