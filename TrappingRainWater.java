//idea comes from:https://github.com/anson627/leetcode/blob/master/TrappingRainWater/TrappingRainWater.cpp
//traverse from both ends
public class TrappingRainWater {
	public int trap(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int sum = 0;
		int n = A.length;
		if (n <= 2) {
			return 0;
		}
		int[] lmax = new int[A.length];
		int[] rmax = new int[A.length];
		lmax[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			lmax[i] = Math.max(A[i], lmax[i - 1]);
		}

		rmax[n - 1] = A[n - 1];
		for (int j = n - 2; j >= 0; j--) {
			rmax[j] = Math.max(A[j], rmax[j + 1]);
		}

		for (int k = 1; k < n-1; k++) {
			int low = Math.min(lmax[k-1], rmax[k+1]);
			sum += (low > A[k]) ? (low-A[k]) : 0;
		}
		return sum;

	}
	
	public static void main(String[] args){
		TrappingRainWater o=new TrappingRainWater();
		int[] A ={4,2,3};
		System.out.println(o.trap(A));
	}
}
