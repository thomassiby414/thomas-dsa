class Solution {
    public int beautySum(String s) {
        // brute force
        // int sum = 0;
        // int n = s.length();
        // for(int i=0; i<n; i++) {
        //     for(int j=i+2; j<n; j++) {
        //         sum += calculateBeauty(s, i, j);
        //     }
        // }
        // return sum; 
        // time = O(n^3)
        // space = O(1)

        // optimal
        int sum = 0;
        for(int i=0; i<s.length(); i++) {
            int freq[] = new int[26];
            for(int j=i; j<s.length(); j++) {
                freq[s.charAt(j)-'a']++;
                if(j-i+1 >= 3) {
                    sum += calculateBeauty(freq);
                }
            }
        }
        return sum;
        // time = O(n^2)
        // space = O(1)
    }

    int calculateBeauty(int freq[]) {
        int maxFreq = Integer.MIN_VALUE, minFreq = Integer.MAX_VALUE;
        for(int f: freq) {
            if(f > 0) {
                if(f > maxFreq) maxFreq = f;
                if(f < minFreq) minFreq = f;
            }
        }
        return maxFreq-minFreq;
    }

    int calculateBeauty(String s, int start, int end) {
        int freq[] = new int[26];
        for(int i=start; i<=end; i++) {
            freq[s.charAt(i)-'a']++;
        }
        int maxFreq = Integer.MIN_VALUE, minFreq = Integer.MAX_VALUE;
        for(int f: freq) {
            if(f > 0) {
                if(f > maxFreq) maxFreq = f;
                if(f < minFreq) minFreq = f;
            }
        }
        return maxFreq-minFreq;
    }
}