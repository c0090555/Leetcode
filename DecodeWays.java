public class DecodeWays {
	public int numDecodings(String s) {
		if(s==null||s.length()==0){
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		dp[s.length()] = 1;

		for (int i = s.length() - 1; i >= 0; i++) {
			if (s.charAt(i) != '0') {
				dp[i] = dp[i + 1];
				if (i < s.length()
						&& Integer.parseInt(s.substring(i, i + 2)) <= 26) {
					dp[i] += dp[i + 2];
				}

			}
		}
		return dp[0];

	}
}
