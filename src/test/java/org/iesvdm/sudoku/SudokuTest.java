package org.iesvdm.sudoku;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class SudokuTest {

    private Sudoku sudoku;

    @BeforeEach
    void setUp() {
        sudoku = new Sudoku();
    }

    @Test
    void failTest() {
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardBasedInCluesRandomlySolvable();
        sudoku.fillBoardBasedInCluesRandomly();
        sudoku.printBoard();
    }

    @Test
    void testFillBoardRandomnly() {
        sudoku.setGridSize(9);
        sudoku.fillBoardRandomly();
        int[][] tablero = sudoku.getBoard();
        Assertions.assertNotNull(tablero);
        Assertions.assertEquals(9, tablero.length);
        Assertions.assertEquals(9, tablero[0].length);
    }

    @Test
    void testBoardBasedInCluesRandomly() {
        sudoku.setGridSize(9);
        sudoku.setNumClues(5);
        sudoku.fillBoardBasedInCluesRandomly();
        int[][] tablero = sudoku.getBoard();
        Assertions.assertNotNull(tablero);

        int pistas = 0;
        for (int[] row : tablero) {
            for (int cell : row) {
                if (cell != 0) {
                    pistas++;
                }
            }
        }
        Assertions.assertEquals(5, pistas);
        assertThat(pistas).isEqualTo(5);
    }


    @Test
    void testSolveBoard() {
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
        sudoku.setBoard(tablero);
        Assertions.assertTrue(sudoku.solveBoard());

        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                //Aquí espero true y sale false;
                assertTrue(sudoku.isValidPlacement(sudoku.getBoard()[fila][col], fila, col));
            }
        }
    }

    @Test
    void testCopyBoard() {
        int[][] tablero = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        sudoku.setGridSize(3);
        sudoku.copyBoard(tablero);

        int[][] tableroCopiado = sudoku.getBoard();
        Assertions.assertArrayEquals(tablero, tableroCopiado);
    }


    @Test
    public void testIsNumberInRow() {
        int[][] tablero = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        sudoku.setBoard(tablero);
        assertThat(sudoku.isNumberInRow(5, 0)).isTrue();
        assertThat(sudoku.isNumberInRow(5, 1)).isFalse();
    }

    @Test
    public void testIsNumberInColumn() {
        int[][] tablero = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        sudoku.setBoard(tablero);
        assertThat(sudoku.isNumberInColumn(5, 0)).isTrue();
        assertThat(sudoku.isNumberInColumn(5, 1)).isFalse();
    }

    @Test
    public void testPutNumberInBoard(){
        int numero = 5;
        int fila = 2;
        int coluna = 3;

        int[][] tablero = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        sudoku.setBoard(tablero);
        sudoku.putNumberInBoard(numero, fila, coluna);
        int[][] tablero2 = sudoku.getBoard();
        assertEquals(5, tablero2[2][3]);

    }

    @Test
    public void testFillBoardSolvable(){
        int[][] tablero = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        sudoku.setBoard(tablero);
        sudoku.fillBoardSolvable();
        int[][] tablero2 = sudoku.getBoard();
        assertNotSame(tablero, tablero2);
    }

    @Test
    public void testFillBoardUnsolvable(){
        int[][] tablero = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        sudoku.setBoard(tablero);
        sudoku.fillBoardUnsolvable();
        int[][] tablero2 = sudoku.getBoard();
        assertNotSame(tablero, tablero2);

    }


}
