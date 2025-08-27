class Solution {
    public boolean isAnagram(String s, String t) {
        // brute force (sorting)
        // if(s.length() != t.length()) return false;
        // char arrS[] = s.toCharArray();
        // char arrT[] = t.toCharArray();
        // Arrays.sort(arrS);
        // Arrays.sort(arrT);
        // return Arrays.equals(arrS, arrT);
        // time = O(nlogn)
        // space = O(n)

        // optimal
        if(s.length() != t.length()) return false;
        int arr[] = new int[26];
        int n = s.length();
        for(int i=0; i<n; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            arr[sc - 'a']++;
            arr[tc - 'a']--;
        }
        for(int count: arr) {
            if(count != 0) return false;
        }
        return true;
        // time = O(n)
        // space = O(1)

        // optimal (Unicode characters)
        // if(s.length() != t.length()) return false;
        // Map<Character, Integer> map = new HashMap<>();
        // int n = s.length();
        // for(int i=0; i<n; i++) {
        //     char sc = s.charAt(i);
        //     char tc = t.charAt(i);
        //     map.put(sc, map.getOrDefault(sc, 0)+1);
        //     map.put(tc, map.getOrDefault(tc, 0)-1);
        // }
        // for(int count: map.values()) {
        //     if(count != 0) return false;
        // }
        // return true;
        // time = O(n)
        // space = O(n)
    }
}