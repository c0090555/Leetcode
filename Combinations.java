import java.util.*;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> comb = new ArrayList<Integer>();
		//base case: k==1
		if (k == 1) {
			for (int i = 1; i <= n; i++) {
				comb = new ArrayList<Integer>();
				comb.add(i);
				result.add(comb);
			}
			return result;
		} else if (k == n) {
			comb = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++) {
				comb.add(i);
			}
			result.add(comb);
			return result;
		} 
		else if(k>n){
			return new ArrayList<ArrayList<Integer>>();
		}
		
		else {
			ArrayList<ArrayList<Integer>> f1 = combine(n - 1, k - 1);// choose n
			ArrayList<ArrayList<Integer>> f2 = combine(n - 1, k);// not choose n

			// add n back to f1
			for (int i = 0; i < f1.size(); i++) {
				f1.get(i).add(n);
			}
			// merge f1 and f2
			f1.addAll(f2);
			return f1;
		}
	}
}
