package dsa;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
 * <p>
 * https://www.ideserve.co.in/learn/next-greater-number-using-same-digits
 */
public class NextGreaterNumber {

    private void swap(int[] number, int i, int j) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }

    private void sortSubarray(int[] number, int i, int j) {
        // for this sub-array, all the digits would be in there reverse sorted position
        while (i < j) {
            swap(number, i, j);
            i += 1;
            j -= 1;
        }
    }

    // 6, 9, 3, 8, 6, 5, 2
    public void findNextGreaterNumber(int[] number) {
        int lastDigitSeen = number[number.length - 1];
        int i;
        int j;
        for (i = number.length - 2; i >= 0; i--) {
            // if this digit is where the sorted ordering breaks
            if (lastDigitSeen > number[i]) {
                break;
            }
            lastDigitSeen = number[i];
        }

        if (i >= 0) // we found the digit breaking the sorted ordering
        {
            // find the next greater digit in the right sub-array from number[i+1 to end]
            for (j = number.length - 1; j > i; j--) {
                if (number[j] > number[i]) {
                    break;
                }
            }

            // swap digits at indices 'i' and 'j'
            swap(number, i, j);
            System.out.println(Arrays.toString(number));
            // sort the sub-array - number[i+1 to end]
            sortSubarray(number, i + 1, number.length - 1);
        }
    }

    public static void main(String[] args) {
        NextGreaterNumber solution = new NextGreaterNumber();

        int[] number = { 6, 9, 3, 8, 6, 5, 2 };

        solution.findNextGreaterNumber(number);

        System.out.println("Next greater number is: ");
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]);
        }
    }
}
