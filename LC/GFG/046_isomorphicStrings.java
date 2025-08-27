class Solution {
    public boolean isIsomorphic(String s, String t) {
        // optimal
        int n = s.length();
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for(int i=0; i<n; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(mapST.containsKey(sc) && mapST.get(sc) != tc) return false;
            if(mapTS.containsKey(tc) && mapTS.get(tc) != sc) return false;
            mapST.put(sc, tc);
            mapTS.put(tc, sc);
        }
        return true;
        // time = O(n) = O(n)
        // space = O(1) since we only map characters, it’s bounded by constant (≤ 256).
        
    }
}