class Solution {
    List<List<Integer>> result = new ArrayList<>();

    void subsequence(int[] nums, int index, List<Integer> current){
        if (current.size() >= 2){
            result.add(new ArrayList<>(current));
        }

        if (index == nums.length) return;

        Set<Integer> used = new HashSet<>();

        for (int i = index;i < nums.length;i++){
            if (used.contains(nums[i])) continue;

            used.add(nums[i]);

            if (current.size() == 0 || nums[i] >= current.get(current.size() - 1)){
                current.add(nums[i]);
                subsequence(nums, i + 1, current);

                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        subsequence(nums, 0, new ArrayList<>());

        return result;
    }
}