public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int length = 0;
		boolean wordStart = false;
		int i = s.length() - 1;
		while (i >= 0) {
			if (s.charAt(i) != ' ' && wordStart == false) {
				length++;
				wordStart = true;
			} else if (wordStart == true && s.charAt(i) != ' ') {
				length++;
			}

			else if (wordStart == true && s.charAt(i) == ' ') {
				break;
			}
			i--;
		}
		return length;
	}
}
