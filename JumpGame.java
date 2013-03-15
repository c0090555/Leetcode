//typical DP
public class JumpGame {
	public boolean canJump(int[] A) {
		int range = 0;
		int i = 0;
		while (i <= range) {
			if (range >= A.length - 1) {
				return true;
			}
			range = Math.max(i + A[i], range);
			i++;
		}
		return false;

	}

}
