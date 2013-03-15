// '.' means the same level
// '..'means the higher level
//key idea: use a stack

//Internal Error

import java.util.*;

public class SimplifyPath {
	public String simplifyPath(String path) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (path.length() == 0) {
			return new String();
		}
		Stack<String> s = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> slash = new ArrayList<Integer>();

		for (int i = 0; i < path.length(); i++) {// store the location of
													// slashes
			if (path.charAt(i) == '/') {
				slash.add(i);
			}
		}

		for (int j = 1; j < slash.size(); j++) {
			if (slash.get(j - 1) + 1 != slash.get(j)) {// there are characters
														// between two slashes
				String name = path
						.substring(slash.get(j - 1) + 1, slash.get(j));
				System.out.println("name " + name);
				if (!name.equals(".")) {// for '.', jut skip it
					if (name.equals("..")) {
						if (!s.isEmpty()) {
							s.pop();
						}
					} else {
						s.add(name);
					}

				}

			}

		}
		if (s.size() == 0) {
			return "/";
		}

		for (int k = 0; k < s.size(); k++) {
			sb.append("/" + s.get(k));
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		SimplifyPath o = new SimplifyPath();
		System.out.println(o
				.simplifyPath("/home/of/foo/../../bar/../../is/./here/."));
	}

}
