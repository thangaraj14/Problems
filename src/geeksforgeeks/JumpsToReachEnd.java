package geeksforgeeks;

import java.util.*;

public class JumpsToReachEnd {

    /**
     * Given an array of non-negative integers nums,
     * you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     *
     * Determine if you are able to reach the last index
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     *
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what.
     * Its maximum jump length is 0, which makes it impossible to reach the last index.
     */
    public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
        int furthestReachSoFar = 0, lastlndex = maxAdvanceSteps.size() - 1;
        
        //i <= furthestReachSoFar && furthestReachSoFar < lastlndex this is the imp part of the solution
        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastlndex; ++i) {
            // for every index store max-steps it can take and i should be
            // less than maxSteps to check if it can move further 
            // e.x (3, 2, 0, 0, 2, 0,1) when index i is 3 maxStpes is also 3, it cannot move further
            furthestReachSoFar = Math.max(furthestReachSoFar, i + maxAdvanceSteps.get(i));
        }
        return furthestReachSoFar >= lastlndex;
    }


    /**
     *Given an array of non-negative integers arr,
     * you are initially positioned at start index of the array.
     * When you are at index i, you can jump to i + arr[i] or i - arr[i],
     * check if you can reach to any index with value 0.
     * Notice that you can not jump outside of the array at any time.
     *
     * Input: arr = [4,2,3,0,3,1,2], start = 5
     * Output: true
     * Explanation:
     * All possible ways to reach at index 3 with value 0 are:
     * index 5 -> index 4 -> index 1 -> index 3
     * index 5 -> index 6 -> index 4 -> index 1 -> index 3
     *
     * Input: arr = [4,2,3,0,3,1,2], start = 0
     * Output: true
     * Explanation:
     * One possible way to reach at index 3 with value 0 is:
     * index 0 -> index 4 -> index 1 -> index 3
     */
    public boolean canReach(int[] arr, int start) {
        // visited check included
        if(start>=arr.length || start<0 || arr[start]>arr.length || arr[start]<0) return false;
        if(arr[start]==0 ) return true;
        arr[start]=-arr[start]; // visited marking
        return canReach(arr, start+arr[start]) || canReach(arr, start-arr[start]);

    }


    public int minJump(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int currentMax=0;
        int currentEnd=0;
        int jumps=0;
        
        for(int i=0;i<nums.length-1;i++){
            currentMax= Math.max(currentMax, i+nums[i]); // assume each index has a ladder
            
            if(currentMax>=nums.length-1){ // if the current pick solves the issue
                jumps++;
                break;
            }
            //Once the current point reaches curEnd, 
            //then trigger another jump, and set the new curEnd with curFarthest, 
            //then keep the above steps, as the following:
            if(currentEnd==i){ // when the current pick of ladder reached last step
                jumps++;
                currentEnd=currentMax;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
       
        List<Integer> list= Arrays.asList(3,3,1,0, 2,0,1);
        System.out.println(canReachEnd(list));
    }
}