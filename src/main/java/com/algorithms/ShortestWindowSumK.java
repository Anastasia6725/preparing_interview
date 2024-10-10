package main.java.com.algorithms;

public class ShortestWindowSumK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int n = nums.length;
        int l = 0;
        int r = 0;
        int minLen = n + 1;
        long sum = 0;
        long t = 15;
        while (l < n) {
            if (r < n && sum < t) {
                sum += nums[r];
                r++;
            } else {
                sum -= nums[l];
                l++;
            }
            if (sum >= t) {
                minLen = Math.min(minLen, (r - l));
            }
        }
        if (minLen == n + 1) {
            minLen = 0;
        }
        System.out.println(minLen);
    }
}
