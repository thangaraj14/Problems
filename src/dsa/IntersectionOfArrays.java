package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82241/AC-solution-using-Java-HashMap
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * <p>
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfArrays {
    public static void main(String[] args) {
        IntersectionOfArrays intersectionOfArrays = new IntersectionOfArrays();
        int[] nums1 = { 4, 4, 9, 5 };
        int[] nums2 = { 9, 4, 9, 4, 2, 3 };
        System.out.println(Arrays.toString(intersectionOfArrays.intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 1));
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }

        return r;
    }
}