
public class SudokuSolver {

	static final int GRID_SIZE = 9;
	
	static int count = 0;

	public static void main(String[] args) {
		int[][] gameBoard = { { 7, 0, 2, 0, 5, 0, 6, 0, 0 }, { 0, 0, 0, 0, 0, 3, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 9, 5, 0, 0 }, { 8, 0, 0, 0, 0, 0, 0, 9, 0 }, { 0, 4, 3, 0, 0, 0, 7, 5, 0 },
				{ 0, 9, 0, 0, 0, 0, 0, 0, 8 }, { 0, 0, 9, 7, 0, 0, 0, 0, 5 }, { 0, 0, 0, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 7, 0, 4, 0, 2, 0, 3 } };

		printBoard(gameBoard);
		System.out.println();
		System.out.println();

		if (solveBoard(gameBoard) == true) {
			System.out.println("The sudoku board has been solved successfully below");
			System.out.println("The program took " + count + " moves to solve it successfully");
			System.out.println();
			System.out.println();
			printBoard(gameBoard);
		}

		else {
			System.out.println("The sudoku board above is unsolvable");
		}

	}

	public static void printBoard(int gameBoard[][]) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println("- - - - - -");
			}
			for (int j = 0; j < GRID_SIZE; j++) {
				if (j % 3 == 0 && j != 0) {
					System.out.print("|");
				}
				System.out.print(gameBoard[i][j]);
			}
			System.out.println();
		}
	}

	public static boolean isValidRowPlacement(int gameBoard[][], int rowNum, int numToCheck) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (gameBoard[rowNum][i] == numToCheck) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidColumnPlacement(int gameBoard[][], int columnNum, int numToCheck) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (gameBoard[i][columnNum] == numToCheck) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidLocalGridPlacement(int gameBoard[][], int rowNum, int columnNum, int NumToCheck) {
		int localBoxRow = rowNum - rowNum % 3;
		int localBoxColumn = columnNum - columnNum % 3;

		for (int i = localBoxRow; i < localBoxRow + 3; i++) {
			for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
				if (gameBoard[i][j] == NumToCheck) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isValidPlacement(int gameBoard[][], int rowNum, int columnNum, int numToCheck) {
		return isValidRowPlacement(gameBoard, rowNum, numToCheck)
				&& isValidColumnPlacement(gameBoard, columnNum, numToCheck)
				&& isValidLocalGridPlacement(gameBoard, rowNum, columnNum, numToCheck);
	}

	public static boolean solveBoard(int[][] gameBoard) {
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if (gameBoard[i][j] == 0) {
					for (int num = 1; num <= GRID_SIZE; num++) {
						if (isValidPlacement(gameBoard, i, j, num) == true) {
							gameBoard[i][j] = num;
							count++;

							if (solveBoard(gameBoard) == true) {
								return true;
							}

							// backtracking
							else {
								gameBoard[i][j] = 0;
							}
						}
					}
					// unsolvable sudoku game grid
					return false;
				}
			}
		}
		return true;
	}
}
