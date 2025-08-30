class Solution {
    public int maxDepth(String s) {
        // optimal
        int max = 0, count = 0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '(') {
                count++;
                max = Math.max(max, count);
            } else if(s.charAt(i) == ')') {
                count--;
            }
        }
        return max;
        // time = O(n)
        // space = O(1)

        // logically you only need to check/update max after an opening bracket 
        // (since depth only grows there). Checking after a ')' won’t ever increase max, 
        // though it doesn’t hurt performance much.
    }
}