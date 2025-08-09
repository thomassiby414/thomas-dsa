class Solution {
    public int[][] merge(int[][] intervals) {
        // List<int[]> ans = new ArrayList<>();
        // Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        // int n = intervals.length;
        // for(int i=0; i<n; i++) {
        //    int start=intervals[i][0], end=intervals[i][1];
        //    if(ans.size()>0 && end<=ans.get(ans.size()-1)[1]) {
        //         continue;
        //    }
        //    for(int j=i+1; j<n; j++) {
        //         if(intervals[j][0] <= end) {
        //             end = Math.max(end, intervals[j][1]);
        //         } else {
        //             break;
        //         }
        //    }
        //    ans.add(new int[]{start,end});
        // }
        // return ans.toArray(new int[0][]);
        // time = O(nlogn)+O(n^2) = O(n^2)
        // space = O(n)

        // optimal
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        for(int i=0; i<intervals.length; i++) {
            int start=intervals[i][0], end=intervals[i][1];
            if(ans.size()==0 || start>ans.get(ans.size()-1)[1]) {
                ans.add(new int[]{start,end});
            } else {
                ans.get(ans.size()-1)[1] = Math.max(end, ans.get(ans.size()-1)[1]);
            }
        }
        return ans.toArray(new int[0][]);
        // time = O(nlogn)+O(n) = O(nlogn)
        // space = O(n)
        
    }
}