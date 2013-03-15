//If the array has consecutive positive numbers, the maximum subarray cannot only have part of them, because adding the rest of them will make the subarray bigger
//Similarly, if the array has consecutive negative numbers because the only reason why we need to put the negative numbers in the maximum subarray is it could connect two bigger positive numbers
//Hence, we can merge the consecutive positive and negative numbers first
//Then scan from left, we main a tempSum, if temSum<0,reset it
import java.util.*;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> merge = new ArrayList<Integer>();
		merge = mergeConsecutive(A);
		for(int i=0;i<merge.size();i++){
			System.out.println("a"+merge.get(i));

		}
		System.out.println(merge.get(0));
		int max_ending_here = 0;
		int max_so_far = Integer.MIN_VALUE;
		for (int i = 0; i < merge.size(); i++) {
			max_ending_here += merge.get(i);
			if(max_ending_here<merge.get(i)){
				max_ending_here = merge.get(i);
			}
			if(max_so_far<max_ending_here){
				max_so_far=max_ending_here;
			}

			
		}
		return max_so_far;

	}

	public ArrayList<Integer> mergeConsecutive(int[] A) {
		ArrayList<Integer> merge = new ArrayList<Integer>();
		int sum = 0;
		boolean positive = false;
		if (A.length == 0) {
			return new ArrayList<Integer>();
		}
		if (A.length == 1) {
			merge.add(A[0]);
			return merge;
		}
		if (A[0] >= 0) {
			positive = true;
		}
	

		sum += A[0];
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i] >= 0) {
				if (positive) {
					sum += A[i];
				} else {
					merge.add(sum);
					positive = true;
					sum = 0;
					sum += A[i];

				}
			} else {
				if (!positive) {
					sum += A[i];
				} else {
					System.out.println("sum"+sum);
					merge.add(sum);
					positive = false;
					sum = 0;
					sum += A[i];

				}

			}
		}
			if (A[A.length - 1] >= 0) {
				if (positive) {
					sum += A[A.length - 1];
					merge.add(sum);
				} else {
					merge.add(sum);
					merge.add(A[A.length - 1]);
				}
			} else {
				if (!positive) {
					sum += A[A.length - 1];
					merge.add(sum);
				} else {
					merge.add(sum);
					merge.add(A[A.length - 1]);
				}
			}
		
		return merge;
	}

	public static void main(String[] args) {
		MaximumSubarray o = new MaximumSubarray();
		int[] x = {31,-41,59,26,-53,58,97,-93,-23,84};
		System.out.println(o.maxSubArray(x));
	}

}
