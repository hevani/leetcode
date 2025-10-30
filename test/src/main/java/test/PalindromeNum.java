package test;

public class PalindromeNum {

	public static void main(String[] args) {
		int x = 121;
		System.out.println(isPalindrome(x));
		
	}
	
	public static boolean isPalindrome(int x) {
        int reverse = 0;
        int actual = x;
        while(x >0) {
            int m = x%10;
            reverse = reverse *10 + m;
            x = x/10;
        }
        return actual == reverse;
    }
}
