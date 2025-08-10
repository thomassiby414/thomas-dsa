class Solution {
    public List<List<Integer>> generate(int numRows) {
        // brute force
        // List<List<Integer>> ans = new ArrayList<>();
        // for(int i=1; i<=numRows; i++) {
        //     List<Integer> row = new ArrayList<>();
        //     for(int j=1; j<=i; j++) {
        //         row.add(nCR(i-1, j-1));
        //     }
        //     ans.add(row);
        // }
        // return ans;  
        // time = O(n^2 * r) ~= O(n^3)
        // space = O(n^2)

        // optimal
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=numRows; i++) {
            List<Integer> row = new ArrayList<>();
            int num = 1;
            row.add(num);
            for(int j=1; j<i; j++) {
                num *= i-j;
                num /= j;
                row.add(num);
            }
            ans.add(row);
        }
        return ans;
        // time = O(n^2)
        // space = O(n^2)
    }

    int nCR(int n, int r) {
        int value = 1;
        for(int i=0; i<r; i++) {
            value *= n-i;
            value /= (i+1);
        }
        return value;
    }
}