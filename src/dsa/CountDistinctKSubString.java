package dsa;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://www.geeksforgeeks.org/count-number-of-substrings-with-exactly-k-distinct-characters/
 * CountKSubStr number of substrings with exactly distinct characters in a given string
 */
public class CountDistinctKSubString {

    private int countKDist(String str, int k) {

        int result = 0;
        int n = str.length();
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            int distinctCount = 0;
            Arrays.fill(count, 0);
            for (int j = i; j < n; j++) {
                if (count[str.charAt(j) - 'a'] == 0) {
                    distinctCount++;
                }
                count[str.charAt(j) - 'a']++;
                if (distinctCount == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountDistinctKSubString ob = new CountDistinctKSubString();
        String ch = "abc";
        int k = 2;
        System.out.println("Total substrings with exactly " + k + " distinct characters : " + ob.countKDist("aba", k));
    }
}
