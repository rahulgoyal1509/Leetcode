class Solution {
    boolean check(int target, int index, String str){
        if (index == str.length()){
            return target == 0;
        }

        int num = 0;

        for (int i = index;i < str.length();i++){
            int n = str.charAt(i) - '0';
            num = num * 10 + n;

            if (check(target - num, i + 1, str)){
                return true;
            }
        }

        return false;
    }

    public int punishmentNumber(int n) {
        int punishmentNumber = 0;

        for (int i = 1;i <= n;i++){
            int val = i * i;
            String str = "" + val;

            if (check(i, 0, str)){
                punishmentNumber += val;
            }
        }

        return punishmentNumber;
    }
}