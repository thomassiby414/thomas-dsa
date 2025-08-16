class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // brute force
        // int minCap=Integer.MIN_VALUE, maxCap=0;
        // for(int weight: weights) {
        //     minCap = Math.max(minCap,weight);
        //     maxCap += weight;
        // }
        // for(int cap=minCap; cap<=maxCap; cap++) {
        //     int daysReq = findDaysReq(weights, cap);
        //     if(daysReq <= days) {
        //         return cap;
        //     }
        // }
        // return -1;
        // time = O(n)+O(nm)= O(nm) where m is the range
        // space = O(1)

        // optimal
        int leastCap = -1;
        int minCap=Integer.MIN_VALUE, maxCap=0;
        for(int weight: weights) {
            minCap = Math.max(minCap, weight);
            maxCap += weight;
        }
        int start=minCap, end=maxCap;
        while(start <= end) {
            int cap = (start+end)/2;
            int daysReq = findDaysReq(weights, cap);
            if(daysReq <= days) {
                leastCap = cap;
                end = cap-1;
            } else {
                start = cap+1;
            }
        }
        return leastCap;
        // time = O(n)+O(nlogm) where m is the range maxCap-minCap
        // space = O(1)
    }

    int findDaysReq(int weights[], int cap) {
        int days=1, load=0;
        for(int weight: weights) {
            load += weight;
            if(load > cap) {
                days++;
                load = weight;
            }
        }
        return days;
    }
}