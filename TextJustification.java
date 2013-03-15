import java.util.*;

public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (words.length == 0 || L == 0) {
			return new ArrayList<String>();
		}
		ArrayList<String> res = new ArrayList<String>();
		String line = new String();
		int size = 0;
		int start = 0;
		for (int i = 0; i < words.length; i++) {
			size += words[i].length();
			if (size > L) {//
				line = padString(start, i - 1, words, L);
				res.add(line);
				size = words[i].length();
				start = i;
			}

		}
		// ending part
		line = padString(start, words.length - 1, words, L);
		res.add(line);
		return res;

	}

	public String padString(int startIndex, int endIndex, String[] words,
			int targetLength) {
		if (startIndex > endIndex) {
			return null;
		}
		int currentLength = 0;
		int diff = 0;
		int gap = 0;
		int firstGap = 0;
		String gapStr = new String();
		String firstGapStr = new String();
		StringBuilder sb = new StringBuilder();

		for (int i = startIndex; i <= endIndex; i++) {
			currentLength += words[i].length();
		}

		diff = targetLength - currentLength;
		if (startIndex == endIndex) {// only one word, left justification
			firstGap = diff;
		} else {
			gap = diff / (endIndex - startIndex + 1);
			firstGap = diff % (endIndex - startIndex + 1) == 1 ? gap + 1 : gap;
		}
		firstGapStr = createPad(firstGap);
		// append the first word
		sb.append(words[startIndex]);
		sb.append(firstGapStr);

		gapStr = createPad(gap);
		for (int i = startIndex + 1; i <= endIndex; i++) {
			sb.append(words[i]);
			if (i != endIndex) {
				sb.append(gapStr);
			}

		}
		return sb.toString();

	}

	public String createPad(int num) {
		if (num == 0) {
			return new String();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= num; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

}
