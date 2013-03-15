//DP
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board.length == 0 || board[0].length == 0 || word.length() == 0) {
			return false;
		}
		boolean[][] visit = new boolean[board.length][board[0].length];
		boolean result = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					visit = new boolean[board.length][board[0].length];
					result = result || existDP(board, word, visit, i, j, 0);
				}
			}
		}
		return result;

	}

	public boolean existDP(char[][] board, String word, boolean[][] visit,
			int row, int col, int step) {
		// System.out.println("row " + row);
		// System.out.println("col " + col);
		// System.out.println("step " + step);
		// System.out.println("length " + word.length());
		if (step == word.length() - 1) {
			return board[row][col] == word.charAt(step);// done
		}
		if (board[row][col] != word.charAt(step)) {
			return false;
		}
		int rowNum = board.length;
		int colNum = board[0].length;
		boolean left = col == 0 ? false : true;
		boolean right = col == colNum - 1 ? false : true;
		boolean up = row == 0 ? false : true;
		boolean down = row == rowNum - 1 ? false : true;
		boolean move = false;

		boolean result = (board[row][col] == word.charAt(step));
		boolean leftRes = false;
		boolean rightRes = false;
		boolean upRes = false;
		boolean downRes = false;

		visit[row][col] = true;
		if (left && !visit[row][col - 1]) {
			// System.out.println("1");
			leftRes = existDP(board, word, visit, row, col - 1, step + 1);
			move = true;

		}
		if (right && !visit[row][col + 1]) {
			// System.out.println("2");
			rightRes = existDP(board, word, visit, row, col + 1, step + 1);
			move = true;

		}
		if (up && !visit[row - 1][col]) {
			// System.out.println("3");
			upRes = existDP(board, word, visit, row - 1, col, step + 1);
			move = true;

		}
		if (down && !visit[row + 1][col]) {
			// System.out.println("4");
			downRes = existDP(board, word, visit, row + 1, col, step + 1);
			move = true;

		}
		// System.out.println("move " + move);
		if (step < word.length() - 1 && !move) {
			return false;
		}
		result = leftRes || rightRes || upRes || downRes;
		// System.out.println("lRes "+leftRes);
		// System.out.println("rRes "+rightRes);
		// System.out.println("uRes "+upRes);
		// System.out.println("dRes "+downRes);
		//
		// System.out.println("result " + result);

		return result;

	}

	public static void main(String[] args) {
		WordSearch o = new WordSearch();
		char[][] board = { { 'a', 'b' } };
		String word = "abb";
		System.out.println(o.exist(board, word));
	}
}
