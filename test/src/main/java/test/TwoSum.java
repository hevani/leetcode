package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
		
		int[] input = {2,7,11,15};
		
		int[] result = twoSum(input, 9);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            System.out.println("complement:" + complement);
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
            System.out.println("map:" + map);
            
        }

        return new int[] {}; 
    }

}
