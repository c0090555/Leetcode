//Given k sorted arrays of size n, merge them into one array
/*
 Two ideas for this problem:
 1. first, divide these k arrays to (k/2) groups, each group has 2n elements, do merge in each group, then we got
 k/2 arrays, similarly merge then (k/4) groups
 2. use a min-heap
 */
import java.util.*;

public class MergeKSortedArrays {
	// solution 1
//	public ArrayList<Integer> mergeKSortedArrays(
//			ArrayList<ArrayList<Integer>> lists) {
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		int k = lists.size();
//		if (k == 0) {
//			return result;
//		}
//		int n = lists.get(0).size();
//		if (n == 0) {
//			return result;
//		}
//		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
//		while(k>1){
//			temp = new ArrayList<ArrayList<Integer>>();
//			int x=k/2;
//			int y=k%2;
//			for(int i=0;i<x;i++){
//			ArrayList<Integer> pair = 	
//			}
//			
//		}
		
		
//	}

	public ArrayList<Integer> mergeTwoArrays(ArrayList<Integer> a,
			ArrayList<Integer> b) {
		if (a.size() != b.size()) {
			return null;
		}
		if (a.size() == 0) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		int len = a.size();
		int ai = 0;
		int bi = 0;
		while (ai <= len - 1 && bi <= len - 1) {
			if (a.get(ai) <= b.get(bi)) {
				result.add(a.get(ai));
				ai++;
			} else {
				result.add(b.get(bi));
				bi++;
			}
		}
		boolean aEnd = (ai <= len - 1) ? true : false;
		if (aEnd) {
			for (int i = ai; i <= len - 1; i++) {
				result.add(a.get(i));
			}
		} else {
			for (int j = bi; j <= len - 1; j++) {
				result.add(b.get(j));
			}
		}
		return result;
	}

}
