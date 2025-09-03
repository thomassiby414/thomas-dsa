class Solution {
    public int[] rearrangeArray(int[] nums) {
        // brute force
        // List<Integer> pos = new ArrayList<>();
        // List<Integer> neg = new ArrayList<>();
        // for(int num: nums) {
        //     if(num > 0) pos.add(num);
        //     else neg.add(num);
        // }
        // for(int i=0; i<pos.size(); i++) {
        //     nums[2*i] = pos.get(i);
        //     nums[2*i+1] = neg.get(i);
        // }
        // return nums;
        // time = O(n)
        // space = O(n)

        // optimal
        int ans[] = new int[nums.length];
        int posInd = 0, negInd = 1;
        for(int num: nums) {
            if(num > 0) {
                ans[posInd] = num;
                posInd += 2;
            } else {
                ans[negInd] = num;
                negInd += 2;
            }
        }
        return ans;
        // time = O(n)
        // space = O(n)
    }
}