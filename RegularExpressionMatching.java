/*it's meaningless to have such regular expression: *. 
 '.' Matches any single character.
 '*' Matches zero or more of the preceding element
 '*' cannont be the first element 

 idea come from:http://blog.csdn.net/hopeztm/article/details/7992253
 use dp[i][j] to indicate s[1..len(s)] could match p[1..len(p)]
 dp[i][j]=
 1).when p[j+1] != '*': if s[i] == p[i], dp[i][j]=dp[i+1][j+1],else dp[i][j]=false
 2).when p[j+1] == '*': expand '*'

 Use recursion

 */

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return isMatch(s, 0, p, 0);
	}

	public boolean isMatch(String s, int indexS, String p, int indexP) {
		if (indexP >= p.length() - 1) {
			return indexS == s.length() - 1;
		}
		System.out.println("indexSaa " + indexS);
		System.out.println("indexPaa " + indexP);
		System.out.println(p.charAt(indexP + 1));
		if (p.charAt(indexP + 1) != '*') {
			System.out.println("begin");
			if (indexS <= s.length() - 1 && indexP <= p.length() - 1
					&& p.charAt(indexP) == s.charAt(indexS)
					|| (p.charAt(indexP) == '.' && indexS <= s.length() - 1)) {
				return isMatch(s, indexS + 1, p, indexP + 1);
			}
			return false;
		} else {
			// expand *
			System.out.println("indexS " + indexS);
			System.out.println("indexP " + indexP);
			while (indexS <= s.length() - 1 && indexP <= p.length() - 1
					&& p.charAt(indexP) == s.charAt(indexS)
					|| (p.charAt(indexP) == '.' && indexS <= s.length() - 1)) {
				if (isMatch(s, indexS, p, indexP + 2)) {
					return true;
				}

				indexS++;
			}
			return isMatch(s, indexS, p, indexP + 2);
		}

	}

	
}
