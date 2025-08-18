class Solution {
    public int minTime(int[] arr, int k) {
        // brute force
        // int minTime=Integer.MIN_VALUE, maxTime=0;
        // for(int num: arr) {
        //     minTime = Math.max(minTime, num);
        //     maxTime += num;
        // }
        // for(int time=minTime; time<=maxTime; time++) {
        //     if(isTimePossible(arr, time, k)) {
        //         return time;
        //     }
        // }
        // return -1;
        // time = O(n)+O(nm) = O(nm) where m=sum(arr)-max(arr)
        // space = O(1)
        
        // optimal
        int ans = -1;
        int minTime=Integer.MIN_VALUE, maxTime=0;
        for(int num: arr) {
            minTime = Math.max(minTime, num);
            maxTime += num;
        }
        int start=minTime, end=maxTime;
        while(start <= end) {
            int time = (start+end)/2;
            if(isTimePossible(arr, time, k)) {
                ans = time;
                end = time-1;
            } else {
                start = time+1;
            }
        }
        return ans;
        // time = O(n)+O(nlogm) = O(nlogm) where m=sum(arr)-max(arr)
        // space = O(1)
    }
    
    boolean isTimePossible(int arr[], int time, int k) {
        int totalTime=0, countPainter=1;
        for(int num: arr) {
            totalTime += num;
            if(totalTime > time) {
                countPainter++;
                totalTime = num;
            }
        }
        return countPainter<=k;
    }
}
