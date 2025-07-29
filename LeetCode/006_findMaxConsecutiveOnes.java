class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // optimal
        int max=0, count=0;
        for(int num: nums) {
            if(num == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
        // time = O(n)
        // space = O(1)
    }
}