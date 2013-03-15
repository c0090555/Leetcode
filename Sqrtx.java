//Attention to overflow: Integer.MAX_VALUE's square root is approximately 46340
// the middle value always >= the square root when x>=4

public class Sqrtx {
	public int sqrt(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0) {
			return -1;
		}
		int mid ;
		int root = 0;
		int low = 0;
		int high = x;

		while (low <= high) {
			mid = (low + high) / 2;
			if (mid > 46340) {// this part is for speeding up
				high = mid - 1;
				continue;
			}
			int y = mid * mid;
			if (y == x) {
				return mid;
			} else if (y > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
				root = mid;// use the floor value

			}

		}
		return root;

	}

	public static void main(String[] args) {
		Sqrtx o = new Sqrtx();
		int n = 2147395599;
		System.out.println(o.sqrt(n));
	}

}
