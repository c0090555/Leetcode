/*Special cases:
1).the integer's last digit is 0
2).overflow, for example: Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. 


idea comes from: https://github.com/zwxxx/LeetCode/blob/825fe4c23fd108675f4e7d41d0130cb3a556ff3b/Reverse_Integer.cpp
do it from the least important digit and digit by digit
 */
public class ReverseInteger {
	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int y = 0;
		while (x > 0) {
			y *= 10;
			y += x % 10;
			x /= 10;
			System.out.println(x + " " + y);

		}
		return y;
	}

	public static void main(String[] args) {
		System.out.print(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		ReverseInteger o = new ReverseInteger();
		System.out.println(o.reverse(2147483647));
	}
}
