package dsa;

/**
 *
 */
public class FirstNonRepeatedCharacter {
    
    public static int firstUniqChar(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        return -1;
    }

    public static void main(String args[]) {
        String str = "dsa";

        int index = firstUniqChar(str);
        if (index == -1) {
            System.out.print("Either all characters are repeating or string is empty");
        } else {
            System.out.print("First non-repeating character" + " is " + str.charAt(index));
        }
    }
}
