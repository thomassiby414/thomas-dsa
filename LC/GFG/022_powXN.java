class Solution {
    public double myPow(double x, int n) {
        // brute force
        // double ans = 1;
        // long nn = n;
        // nn = Math.abs(nn);
        // for(int i=0; i<nn; i++) {
        //     ans *= x;
        // }
        // if(n < 0) return 1/ans;
        // return ans;
        // time = O(n)

        // optimal
        double ans = 1;
        long nn = n;
        nn = Math.abs(nn);
        while(nn > 0) {
            if(nn%2 == 1) {
                ans = ans*x;
                nn = nn-1;
            } else {
                x = x*x;
                nn = nn/2;
            }
        }
        if(n < 0) return 1/ans;
        return ans;
        
    }
}