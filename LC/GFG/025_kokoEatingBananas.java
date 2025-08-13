class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // brute force
        // int max = findMax(piles);
        // for(int i=1; i<=max; i++) {
        //     int totalHours = calculateHours(piles,i);
        //     if(totalHours <= h) {
        //         return i;
        //     }
        // }
        // return -1;
        // time = O(n)+O(m*n) = O(m*n)
        // space = O(1)

        // optimal
        int ans = 0;
        int max = findMax(piles);
        int start=1, end=max;
        while(start <= end) {
            int mid = (start+end)/2;
            int totalHours = calculateHours(piles,mid);
            if(totalHours <= h) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
        // time = O(n)+O(logm*n) = O(nlogm)
        // space = O(1)
    }

    int findMax(int piles[]) {
        int max = Integer.MIN_VALUE;
        for(int num: piles) {
            max = Math.max(max, num);
        }
        return max;
    }

    int calculateHours(int piles[], int bananaCount) {
        int hours = 0;
        for(int num: piles) {
            hours += Math.ceil((double)num/(double)bananaCount);
        }
        return hours;
    }
}