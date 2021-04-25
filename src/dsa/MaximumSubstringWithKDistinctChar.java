package dsa;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * <p>
 * https://www.lintcode.com/problem/longest-substring-with-at-most-two-distinct-characters/description
 */
public class MaximumSubstringWithKDistinctChar {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba", 2));
        //System.out.println(lengthOfLongestSubstringKDistinct("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 2));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int counter = 0;
        int length = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                counter++;//new char
            }
            end++;
            while (counter > k) {
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if (map.get(cTemp) == 0) {
                    counter--;
                }
                start++;
            }
            length = Math.max(length, end - start);
        }
        return length;
    }
}
