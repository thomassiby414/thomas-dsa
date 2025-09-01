class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), count = 0;
        int lastA = -1, lastB = -1, lastC = -1;
        for(int i=0; i<n ; i++) {
            char ch = s.charAt(i);
            if(ch == 'a') lastA = i;
            else if(ch == 'b') lastB = i;
            else lastC = i;
            if(lastA != -1 && lastB != -1 && lastC != -1) {
                int min = Math.min(lastA, Math.min(lastB, lastC));
                count += min + 1;
            }
        }
        return count;
        // time = O(n)
        // space = O(1)
    }
}