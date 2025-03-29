/**
 *   https://www.callicoder.com/two-sum-problem/ 
 * 
 *   cd D:\Projects\JavaProjects\HackerRank\TwoSum.java
 * 
 *   Two Sum
 *   Two Number Sum Problem Statement
 *   Given an array of integers, return the indices of the two numbers whose sum is equal to a given target.
 *   You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *  
 */



import java.util.HashMap;
import java.util.Map;

 class TwoSum {

    /**
     * twoSum accepts an array and target value.
     * @param nums 
     * @param target
     * @return an array with 2 elements for the indices.
     */
    static int[] twoSum( int [] nums, int target ) {

        // key, value. key =((elem - target) = complement). value = (elem).
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            int complement = target - elem; // elem + complement = target

            // {1,8,3,4,5,6,7,10};
            if(map.containsKey(complement) ){

                // return the result array with the index and index.
                return new int [] {map.get(complement), i };
               
            } else {
                    // store the element and the index position.
                    map.put(elem, i);
            }
        }

        return new int[] {};
    }

 public static void main(String [] args){

    System.out.println("----    Two Sum    ----");

    int [] input = {1,8,3,4,5,6,7,10};
    int target = 9;
    int [] result = twoSum(input, target);
    System.out.println( " [" + result[0] + " , " + result[1] + "]"  );
 }
}