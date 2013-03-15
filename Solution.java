import java.util.ArrayList;
import java.io.*;

public class Solution {
	public int solver(int[] pos, int k) {
		if (k < 0) {
			return 0;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		placeKing(pos, k, result);
		int res = result.size()%1000000007;
		return res;

	}

	public void placeKing(int[] pos, int row, ArrayList<Integer> result) {
		int n = pos.length;
		if (row == n) {// finish placing all n queens, so print the result
			result.add(1);
			return;

		}

		for (int i = 0; i < n; i++) {// try to find a valid column for row
			if (feasible(pos, row, i)) {
				pos[row] = i;
				placeKing(pos, row + 1, result);
			}
		}

	}

	public boolean feasible(int[] pos, int row, int col) {
		if (row == 0) {
			return true;
		}
		for (int i = 0; i < row; i++) {
			if (pos[i] == col) {
				return false;
			}
		}
		// System.out.println("prev" + pos[row - 1]);
		if (Math.abs(col - pos[row - 1]) <= 1) {// check diagonal
			return false;
		}
		return true;

	}

	public static void main(String[] args) {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ir);
		Solution o = new Solution();
		int t;
		int n = 0;
		int k = 0;
		String line = new String();

		try {
			line = in.readLine();
			t = Integer.parseInt(line);
			for (int i = 0; i < t; i++) {
				line = in.readLine();
				String[] arr = line.trim().split("\\s+");
				n = Integer.parseInt(arr[0]);
				k = Integer.parseInt(arr[1]);

				line = in.readLine();
				if (k == 0) {
					int[] pos = new int[n];
					System.out.println(o.solver(pos, k));
					continue;
				}
				arr = line.trim().split("\\s+");
				int[] pos = new int[n];
				for (int j = 0; j < k; j++) {
					pos[j] = Integer.parseInt(arr[j]);
				}
				System.out.println(o.solver(pos, k));

			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
