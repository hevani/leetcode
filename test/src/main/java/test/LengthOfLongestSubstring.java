package test;

import java.util.HashMap;
import java.util.Map;

//Sliding Window solution
public class LengthOfLongestSubstring {
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		String s1 = "bbbbb";
		String s2 = "pwwkew";

		System.out.println(s + ",lengthOfLongestSubstring:" + lengthOfLongestSubstring(s));
		System.out.println(s1 + ",lengthOfLongestSubstring:" + lengthOfLongestSubstring(s1));
		System.out.println(s2 + ",lengthOfLongestSubstring:" + lengthOfLongestSubstring(s2));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int left = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int right=0; right <s.length(); right++) {
			Character c = s.charAt(right);
			if(map.containsKey(c)) {
				left = Math.max(maxLength, map.get(c) + 1);	
			}
			map.put(c, right);
			maxLength = Math.max(maxLength, right-left +1);
		}
		
		return maxLength;
		
	}

}
