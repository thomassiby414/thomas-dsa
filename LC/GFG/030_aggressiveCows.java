class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // brute force
        // int ans = -1;
        // Arrays.sort(stalls);
        // int minPos=stalls[0], maxPos=stalls[stalls.length-1];
        // for(int distance=1; distance<=maxPos-minPos; distance++) {
        //   if(isCowsPossible(stalls, distance , k)) {
        //       ans = distance;
        //   } else {
        //       break;
        //   }
        // }
        // return ans;
        // time = (nlogn)+O(n (max-min)) 
        // space = O(1)
        
        // optimal
        int ans = -1;
        Arrays.sort(stalls);
        int minPos=stalls[0], maxPos=stalls[stalls.length-1];
        int start=1, end=maxPos-minPos;
        while(start <= end) {
            int distance = (start+end)/2;
            if(isCowsPossible(stalls, distance, k)) {
                ans = distance;
                start = distance+1;
            } else {
                end = distance-1;
            }
        }
        return ans;
        // time = O(nlogn)+O(nlog(max-min))
        // space = O(1)
    }
    
    boolean isCowsPossible(int stalls[], int distance, int cows) {
        int cowCount= 1, lastPos=stalls[0];
        for(int i=1; i<stalls.length; i++) {
            if(stalls[i]-lastPos >= distance) {
                cowCount++;
                lastPos = stalls[i];
            }
            if(cowCount >= cows) return true;
        }
        return false;
    }
}