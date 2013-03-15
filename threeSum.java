import java.util.*;

public class threeSum {
	public ArrayList<ArrayList<Integer>> threeSumMethod(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(num);
		int[] opposite = new int[num.length];
		int sum = 0;
		ArrayList<Integer> threeNum;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Hashtable<Integer, Integer> count = new Hashtable<Integer, Integer>();
		Hashtable<ArrayList<Integer>, Boolean> occurrence = new Hashtable<ArrayList<Integer>, Boolean>();
		for (int i = 0; i < num.length; i++) {
			opposite[i] = num[i] * (-1);
			if (!count.containsKey(num[i])) {
				count.put(num[i], 1);
			} else {
				int val = count.get(num[i]);
				count.put(num[i], val + 1);
			}
		}
		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(opposite));

		System.out.println(count);

		// sliding window
		for (int i = 0; i < num.length; i++) {
			int start = 0;
			int end = num.length - 1;
			while (start < end) {
				System.out.print("i:" + i);
				System.out.print("opposite: " + opposite[i]);
				System.out.print("start:" + num[start] + " ");
				System.out.print("end" + num[end] + " ");
				sum = num[start] + num[end];
				System.out.print("sum:" + sum + " ");
				if (sum ==opposite[i]) {
					if ((num[start] == opposite[i]&& count.get(opposite[i]) <= 1) || (num[end] == opposite[i]&& count.get(opposite[i]) <= 1)) {
						System.out.println("false!!!");

					}

					else {
						threeNum = new ArrayList<Integer>();
						threeNum.add(opposite[i]);
						threeNum.add(num[start]);
						threeNum.add(num[end]);
						System.out.println("threeNum: " + threeNum);
						Collections.sort(threeNum);
						if (!occurrence.containsKey(threeNum)) {
							result.add(threeNum);
							occurrence.put(threeNum, true);
						}
					}

					start++;
					end--;
				} else if (sum > opposite[i]) {
					end--;
				} else {
					start++;
				}
			}

		}
		return result;
	}

	public static void main(String[] args) {
		int[] number = { -1, 2, 3, -2, 0, 4, 0, 0 };
		// Start typing your code here...
		threeSum o = new threeSum();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result = o.threeSumMethod(number);
		System.out.println(result);

	}

}
