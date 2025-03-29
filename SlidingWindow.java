/**
 * 
 * 
 * 
 *   cd D:\Projects\JavaProjects\HackerRank\SlidingWindow.java
 * 
 */



public class SlidingWindow {
    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            throw new IllegalArgumentException("Array length must be greater than or equal to k");
        }

        // Calculate the sum of the first window
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;
        // Slide the window from start to end of the array
        for (int i = k; i < n; i++) {
            
            // Crawl right adding ith element, and subtracting left-most element. 
            windowSum += arr[i] - arr[i - k];
            
            // Capture the maximum value, but not the position of window.
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + " is: " + maxSumSubarray(arr, k));
    }
}



