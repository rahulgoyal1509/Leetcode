class Solution {
    int maxLen = 0;

    void findLength(List<String> arr, int index, int length, boolean[] unique){
        maxLen = Math.max(maxLen, length);

        if (index >= arr.size()){
            maxLen = Math.max(maxLen, length);
            return;
        }

        String str = arr.get(index);

        boolean flag = true;
        for (int i =  0;i < str.length();i++){
            char ch = str.charAt(i);
            if (unique[ch - 'a']){
                for (int j = 0;j < i;j++){
                    unique[str.charAt(j) - 'a'] = false;
                }

                flag = false;
                break;
            }

            unique[ch - 'a'] = true;
        }

        if (flag){
            findLength(arr, index + 1, length + str.length(), unique);

            for (int i =  0;i < str.length();i++){
                char ch = str.charAt(i);
                unique[ch - 'a'] = false;
            }
        }

        findLength(arr, index + 1, length, unique);
    }

    public int maxLength(List<String> arr) {
        boolean[] unique = new boolean[26];

        findLength(arr, 0, 0, unique);

        return maxLen;
    }
}