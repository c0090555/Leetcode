import java.util.*;

public class FourSum {
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<Integer> fourSum = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Hashtable<ArrayList<Integer>, Boolean> occur = new Hashtable<ArrayList<Integer>, Boolean>();
		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				for (int k = j + 1, l = num.length - 1; k < l;) {
					if (num[i] + num[j] + num[k] + num[l] == target) {
						fourSum = new ArrayList<Integer>();
						fourSum.add(num[i]);
						fourSum.add(num[j]);
						fourSum.add(num[k]);
						fourSum.add(num[l]);
						Collections.sort(fourSum);
						System.out.println("fourSum: "+fourSum);
						if (!occur.containsKey(fourSum)) {
							occur.put(fourSum, true);
							result.add(fourSum);
						}
						l--;
						k++;
					} else if (num[i] + num[j] + num[k] + num[l] > target) {
						l--;
					} else {
						k++;
					}
				}

			}
		}
		return result;
	}
	
	public static void main(String[] args){
		int num[] = {0,-2,1,3,5,2,3,5,6,2,-3,0,0,0,-6};
		ArrayList<ArrayList<Integer>> result = fourSum(num,0);
		System.out.println(result);
		
	}

}
