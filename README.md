# Sudoku-Solver
This automated sudoku solving algorithim coded in java uses back tracking, nested looping, recurssion and two dimensional arrays.

The algorithim places a number between 1 and 9 in a spot on the board and calls other methods to see if the placement is valid following the rules of the game. If it is valid it places the number on that spot and then uses looping and recusrssion to traverse the entire board to find the next blank spot and repeat the same process. If no number is valid on the next spot, it will backtrack to the previous spots and change that number so to make a valid number possible for the next spot. It cotinues this process till the entire board is solved.

The sudoku solver also has the functionality to identify unsolvable boards by returning false if the above process at some point fails even with backtracking.
