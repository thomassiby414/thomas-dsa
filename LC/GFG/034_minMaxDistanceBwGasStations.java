class Section {
    double length;
    int index;
    
    Section(double length, int index) {
        this.length = length;
        this.index = index;
    }
}

class Solution {
    public static double findSmallestMaxDist(int stations[], int k) {
        // brute force
        // int n = stations.length;
        // int howMany[] = new int[n-1];
        // for(int i=1; i<=k; i++) {
        //     double maxSection=-1;
        //     int maxInd=-1;
        //     for(int j=0; j<n-1; j++) {
        //         double diff = stations[j+1]-stations[j];
        //         double sectionLength = diff/(double)(howMany[j]+1);
        //         if(sectionLength > maxSection) {
        //             maxSection = sectionLength;
        //             maxInd = j;
        //         }
        //     }
        //     howMany[maxInd]++;
        // }
        // double ans = -1;
        // for(int i=0; i<n-1; i++) {
        //     double diff = stations[i+1]-stations[i];
        //     double sectionLength = diff/(double)(howMany[i]+1);
        //     ans = Math.max(ans, sectionLength);
        // }
        // return ans;
        // time = O(k*n)+O(n) = O(k*n)
        // space = O(n)
        
        // better
        // int n = stations.length;
        // int addedStations[] = new int[n-1];
        // PriorityQueue<Section> pq = new PriorityQueue<>(
        //     (a, b) -> Double.compare(b.length, a.length)
        // );
        // for(int i=0; i<n-1; i++) {
        //     pq.add(new Section(stations[i+1]-stations[i], i));
        // }
        // for(int i=1; i<=k; i++) {
        //     Section top = pq.poll();
        //     int index = top.index;
        //     addedStations[index]++;
        //     double diff = stations[index+1]-stations[index];
        //     double length = diff / (double) (addedStations[index] + 1);
        //     pq.add(new Section(length, index));
        // }
        // return pq.peek().length;
        // // time = O(n*logn)+O(k*logn)
        // // space = O(n)
        
        // optimal
        double ans = -1;
        int n = stations.length;
        double start=0, end=0;
        for(int i=0; i<n-1; i++) {
            end = Math.max(end, (double)(stations[i+1]-stations[i]));
        }
        while(end-start > 1e-5) {
            double mid = (start+end)/2;
            int cnt = noOfGasStationsRequired(mid, stations);
            if(cnt <= k) {
                ans = mid;
                end = mid;
            } else {
                start = mid;
            }
        }
        return ans;
        // time = O(n)+O(nlogm) where m is the range max(length)-0
        // space = O(1)
    }
    
    public static int noOfGasStationsRequired(double length, int[] stations) {
        int n = stations.length;
        int cnt = 0;
        for (int i=0; i<n-1; i++) {
            int numberInBetween = (int)((stations[i+1] - stations[i]) / length);
            if ((stations[i+1] - stations[i]) == (length * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }
}
