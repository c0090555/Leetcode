/*
 * Implement pow(x, n). 

 Solution: use recursion (divide and conquer)
 * 
 * 
 */
public class Power {
	public double pow(double x, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (n == 0) {
			return 1.0;
		}
		if (x == 0) {
			return 0;
		}
		if (n > 0) {
			if (n % 2 == 0) {
				double t = pow(x, n / 2);// for even number, do it as binary
				return t * t;
			} else {
				return pow(x, n - 1) * x;// for odd number, just minus one to
											// have a even number
			}
		} else {
			if (n % 2 == 0) {
				double t = pow(x, n / 2);
				return t * t;
			} else {
				if (n == Integer.MIN_VALUE) {
					return 1 / (pow(x, Integer.MAX_VALUE) * x);
				} else {
					return 1 / (pow(x, -n - 1) * x);
				}
			}
		}

	}

	public static void main(String[] args) {
		Power o = new Power();
		double x = 2.0;
		int n = -2;
		System.out.println(o.pow(x, n));
	}

}
