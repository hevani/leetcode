package test;

public class RemoveDuplicates {
	
	public static void main(String args[]) {
		
		int[] nums = {1,1,2};
		
		int size = removeDuplicates(nums);
		System.out.println(size);
		for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
		
		int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
		
		int size1 = removeDuplicates(nums1);
		System.out.println("\n" + size1);
		for (int i = 0; i < size1; i++) {
            System.out.print(nums1[i] + " ");
        }
		
	}
	
	public static int removeDuplicates(int[] nums) {
        if (nums.length < 1) return 0;

        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

}
