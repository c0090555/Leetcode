//DP
public class JumpGameII {
	public int jump(int[] A) {
		int[] steps = new int[A.length];
		int limit = 0;// reachable range *
		steps[0] = 0;

		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] + i > limit) {
				if (A[i] + i >= A.length - 1) {
					System.out.println("i " + i);
					System.out.println("stepsi" + steps[i]);

					return steps[i] + 1;
				}
				for (int j = limit + 1; j <= i + A[i] && j <= A.length - 1; j++) {
					steps[j] = steps[i] + 1;
				}
				limit = A[i] + i;

			}

		}

		return steps[A.length - 1];

	}

	public static void main(String[] args) {
		JumpGameII o = new JumpGameII();
		int[] a = { 7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3 };
		System.out.print(o.jump(a));
	}

}
