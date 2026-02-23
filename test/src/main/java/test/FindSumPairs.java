package test;

import java.util.HashSet;

public class FindSumPairs {
	
	public static void main(String[] args) {

		int[] arr = { 2, 4, 3, 5, 7, 8, 9 };
		int target = 10;
		HashSet<Integer> set = new HashSet<>();
		boolean found = false;
		for (int num : arr) {
			int complement = target - num;
			if (set.contains(complement)) {
				System.out.println(num + " + " + complement + " = " + target);
				found = true;
			}
			set.add(num);
		}
		if (!found) {
			System.out.println("No matching pairs found.");
		}

	}

}
