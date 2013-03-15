//2 Dimensional DP
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s3.length() != s1.length() + s2.length()) {
			return false;
		}
		if (s1.length() == 0) {
			return s2.equals(s3);
		}
		if (s2.length() == 0) {
			return s1.equals(s3);
		}
		boolean matrix[][] = new boolean[s1.length()][s2.length()];
		return isInterleave(s1, s1.length(), s2, s2.length(), s3, s3.length(),
				matrix);

	}

	public boolean isInterleave(String s1, int len1, String s2, int len2,
			String s3, int len3, boolean[][] matrix) {
		if (len1 == 0 && len2 == 0 && len3 == 0) {
			return true;
		}
		if (len1 < 0 || len2 < 0 || len3 < 0) {
			return false;
		}
		if (len1 + len2 != len3) {
			return false;
		}
		if (len1 >= 1 && len2 >= 1) {
			matrix[len1 - 1][len2 - 1] = ((s1.charAt(len1 - 1) == s3
					.charAt(len3 - 1)) && isInterleave(s1, len1 - 1, s2, len2,
					s3, len3 - 1, matrix))
					|| ((s2.charAt(len2 - 1) == s3.charAt(len3 - 1)) && isInterleave(
							s1, len1, s2, len2 - 1, s3, len3 - 1, matrix));
		} else {
			if (len1 >= 1) {
				matrix[len1 - 1][0] = (s1.charAt(len1 - 1) == s3
						.charAt(len3 - 1))
						&& isInterleave(s1, len1 - 1, s2, 0, s3, len3 - 1,
								matrix);
			}
			if (len2 >= 1) {
				matrix[0][len2 - 1] = (s2.charAt(len2 - 1) == s3
						.charAt(len3 - 1))
						&& isInterleave(s1, 0, s2, len2 - 1, s3, len3 - 1,
								matrix);

			}
		}
		return matrix[0][0];

	}

	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "b";
		String s3 = "ab";
		InterleavingString o = new InterleavingString();
		System.out.println(o.isInterleave(s1, s2, s3));
	}

}
