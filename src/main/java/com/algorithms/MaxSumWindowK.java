package java.com.algorithms;

import java.util.HashMap;

public class MaxSumWindowK {
    public static void main(String[] args){
        float currentSum = 0, maxSum = 0;
        int left = 0, i = 0;
        int k=3;
        int[] arr = {1, 5, 4, 2, 9, 9, 9};
        HashMap<Integer, Integer> storageEl = new HashMap<>();
        while (i<k){
            currentSum += arr[i];
            if(storageEl.containsKey(arr[i]))
                storageEl.put(arr[i], storageEl.get(arr[i]) + 1);
            else
                storageEl.put(arr[i], 1);
            i++;
        }
        if(storageEl.size() == k){
            maxSum = Math.max(maxSum,currentSum);
        }

        for(i=k; i<arr.length; i++){
            if(storageEl.containsKey(arr[i]))
                storageEl.put(arr[i], storageEl.get(arr[i]) + 1);
            else
                storageEl.put(arr[i], 1);

            if(storageEl.containsKey(arr[left])){
                storageEl.put(arr[left], storageEl.get(arr[left])-1);
                if(storageEl.get(arr[left]) <= 0){
                    storageEl.remove(arr[left]);
                }
                currentSum += arr[i];
                currentSum -= arr[left];

                if(storageEl.size() == k){
                    maxSum = Math.max(maxSum,currentSum);
                }

                left++;

            }
        }
        System.out.println(maxSum);
    }
}