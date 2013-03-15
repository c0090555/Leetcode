//google grey code
// 1.construction of grey code: (num>>1)^num
// 2.use a dp idea, assume sequence[n] is the gray code sequence in n digits
//if we reverse sequence[n] and add a '1' to the left side of each numbers, then we get the new reverse 
//sequence newReverse[n]
//combine sequence[n] and newReverse[n] to get sequence[n+1]
import java.util.*;

public class GreyCode {
	public ArrayList<Integer> grayCodeUsingFormula(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < Math.pow(2.0, n); i++) {
			res.add((i >> 1) ^ i);
		}
		return res;
	}

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(0);// append the first element of gray code sequence - 0
		for (int i = 1; i <= n; i++) {
			int addedOne = 1 << (i - 1);
			for (int j = res.size() - 1; j >= 0; j--) {
				res.add(res.get(j) | addedOne);
				
			}
		}
		return res;
	}
	public static void main(String[] args){
		GreyCode o = new GreyCode();
		int n=2;
		ArrayList<Integer> res = o.grayCode(n);
		for(int i=0;i<res.size();i++){
			System.out.print(res.get(i)+" ");
		}
	}

}