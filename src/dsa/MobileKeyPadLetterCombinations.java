package dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/find-possible-words-phone-digits/
 * <p>
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class MobileKeyPadLetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] keypad = { "--", "00", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        generateCombinations(digits, keypad, 0, new StringBuilder(), result);
        return result;
    }

    public void generateCombinations(String digits, String[] keypad, int startIndex, StringBuilder sb,
            List<String> result) {
        if (startIndex == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (char ch : keypad[digits.charAt(startIndex) - '0'].toCharArray()) {
            sb.append(ch);
            generateCombinations(digits, keypad, startIndex + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        new MobileKeyPadLetterCombinations().letterCombinations("23").forEach(System.out::println);
    }

    public List<String> letterCombinationsIterative(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }
}