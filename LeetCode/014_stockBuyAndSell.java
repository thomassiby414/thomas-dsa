class Solution {
    public int maxProfit(int[] prices) {
        // brute force
        // int max = 0;
        // for(int i=0; i<prices.length; i++) {
        //     for(int j=i+1; j<prices.length; j++) {
        //         int profit = prices[j]-prices[i];
        //         max = Math.max(max, profit);
        //     }
        // }
        // return max;
        // time = O(n^2)
        // space = O(1)

        // optimal
        int max=0, min=prices[0];
        for(int i=1; i<prices.length; i++) {
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return max;
        // time = O(n)
        // space = O(1)
    }
}