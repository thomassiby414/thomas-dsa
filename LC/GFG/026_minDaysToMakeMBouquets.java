class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // brute force
        // int earliestBloom=Integer.MAX_VALUE, latestBloom=Integer.MIN_VALUE;
        // for(int bloom: bloomDay) {
        //     earliestBloom = Math.min(earliestBloom,bloom);
        //     latestBloom = Math.max(latestBloom,bloom);
        // }
        // for(int day=earliestBloom; day<=latestBloom; day++) {
        //     int bouquets = countBouquetsOnDay(bloomDay,day,k);
        //     if(bouquets >= m) {
        //         return day;
        //     }
        // }
        // return -1;
        // time = O(n*range) where range = latestBloom-earliestBloom+1
        // space = O(1)

        // optimal
        int minDay = -1;
        int earliestBloom=Integer.MAX_VALUE, latestBloom=Integer.MIN_VALUE;
        for(int bloom: bloomDay) {
            earliestBloom = Math.min(earliestBloom, bloom);
            latestBloom = Math.max(latestBloom, bloom);
        }
        while(earliestBloom <= latestBloom) {
            int day = (earliestBloom+latestBloom)/2;
            int bouquets = countBouquetsOnDay(bloomDay,day,k);
            if(bouquets >= m) {
                minDay = day;
                latestBloom = day-1;
            } else {
                earliestBloom = day+1;
            }
        }
        return minDay;
        // time = O(n)+O(log(range)) = O(n log(range))
        // space = O(1)
    }

    int countBouquetsOnDay(int bloomDay[], int day, int k) {
        int bouquets=0, consecutiveFlowers=0;
        for(int bloom: bloomDay) {
            if(bloom <= day) {
                consecutiveFlowers++;
            } else {
                bouquets += consecutiveFlowers/k;
                consecutiveFlowers = 0;
            }
        }
        bouquets += consecutiveFlowers/k;
        return bouquets;
    }
}