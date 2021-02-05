package geeksforgeeks;

/**
 * https://leetcode.com/articles/desing-compressed-string-iterator/
 * <p>
 * 604. Design Compressed String Iterator
 * <p>
 * Design and implement a data structure for a compressed string iterator. The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
 * <p>
 * Implement the StringIterator class:
 * <p>
 * next() Returns the next character if the original string still has uncompressed characters, otherwise returns a white space.
 * hasNext() Returns true if there is any letter needs to be uncompressed in the original string, otherwise returns false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["StringIterator", "next", "next", "next", "next", "next", "next", "hasNext", "next", "hasNext"]
 * [["L1e2t1C1o1d1e1"], [], [], [], [], [], [], [], [], []]
 * Output
 * [null, "L", "e", "e", "t", "C", "o", true, "d", true]
 * <p>
 * Explanation
 * StringIterator stringIterator = new StringIterator("L1e2t1C1o1d1e1");
 * stringIterator.next(); // return "L"
 * stringIterator.next(); // return "e"
 * stringIterator.next(); // return "e"
 * stringIterator.next(); // return "t"
 * stringIterator.next(); // return "C"
 * stringIterator.next(); // return "o"
 * stringIterator.hasNext(); // return True
 * stringIterator.next(); // return "d"
 * stringIterator.hasNext(); // return True
 */
public class DesignCompressedStringIterator {

    String result;
    int ptr = 0;
    int num = 0;
    char ch = ' ';

    public DesignCompressedStringIterator(String s) {
        result = s;
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        if (num == 0) {
            ch = result.charAt(ptr++);
            while (ptr < result.length() && Character.isDigit(result.charAt(ptr))) {
                num = num * 10 + result.charAt(ptr++) - '0';
            }
        }
        num--;
        return ch;
    }

    public boolean hasNext() {
        return ptr != result.length() || num != 0;
    }

    public static void main(String[] args) {
        DesignCompressedStringIterator compressedStringIterator = new DesignCompressedStringIterator("L1e21t1C1o1d1e1");
        System.out.println(compressedStringIterator.next());
        System.out.println(compressedStringIterator.next());
        System.out.println(compressedStringIterator.next());
    }

}
