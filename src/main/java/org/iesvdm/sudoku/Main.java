package org.iesvdm.sudoku;

public class Main {
    public static void main(String[] args) {

        Sudoku sudokuSolver = new Sudoku();

        int[][] tablero = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        sudokuSolver.setBoard(tablero);
        sudokuSolver.setGridSize(9);
        sudokuSolver.fillBoardRandomly();

        sudokuSolver.printBoard();

        if (sudokuSolver.solveBoard()) {
            System.out.println("Solved successfully!");
        } else {
            System.out.println("Unsolvable board :(");
        }

        sudokuSolver.printBoard();

    }
}
