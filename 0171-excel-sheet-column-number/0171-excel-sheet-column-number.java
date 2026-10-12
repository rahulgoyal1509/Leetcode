class Solution {
    public int titleToNumber(String columnTitle) {
        int colNum = 0, count = 0;

        for (int i = columnTitle.length() - 1;i >= 0;i--){
            char ch = columnTitle.charAt(i);
            int val = ch - 'A' + 1;

            colNum += val * Math.pow(26, count);
            count++;
        }

        return colNum;
    }
}