class Solution {
    public int romanToInt(String s) {
        // optimal
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++) {
            int curr = map.get(s.charAt(i));
            if(i < n - 1 && curr < map.get(s.charAt(i + 1))) {
                ans -= curr;
            } else {
                ans += curr;
            }
        }
        return ans;
        // time = O(n)
        // space = O(1)
        
    }
}