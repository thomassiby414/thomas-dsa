class Solution {
    public boolean rotateString(String s, String goal) {
        // brute force
        // if(s.equals(goal)) return true;
        // if (s.length() != goal.length()) return false;
        // int n = s.length();
        // for(int i=1; i<n; i++) {
        //     if((s.substring(i, n) + s.substring(0, i)).equals(goal)) return true;
        // }
        // return false;
        // time = O(n^2) - O(n) itll take for sb
        // space = O(n)

        // optimal
        return (s.length() == goal.length() && (s+s).contains(goal));
        // time = O(n)
        // space = O(n)
    }
}