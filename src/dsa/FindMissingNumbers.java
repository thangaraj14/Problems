package dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Input: [2, 3, 7, 8, 2, 3, 5, 7]
// Output: 4, 6, 7

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
 */
public class FindMissingNumbers {

    //Brute Force
    // Set<Integer> set = new HashSet<>();
    // for (int i = 0; i < nums.length; i++) set.add(i + 1);
    // for (int i = 0; i < nums.length; i++) set.remove(nums[i]);
    // return new ArrayList<>(set);
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        int i = 0;
        // cyclic sort begins
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        // cyclic sort ends
        // when cyclic sort ends the i+1 element will be in correct index
        List<Integer> result = new ArrayList<>();
        i = 0;
        while (i < nums.length) {
            if (i + 1 != nums[i]) {
                result.add(i + 1);
            }
            i++;
        }
        return result;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        findDisappearedNumbers(new int[] { 2, 3, 7, 8, 2, 3, 5, 7 });
    }
}