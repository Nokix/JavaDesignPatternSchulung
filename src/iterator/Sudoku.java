package iterator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Sudoku implements Iterable<Integer>{
    private int size;
    private int[][] board;

    public Sudoku(int[][] board) {
        this.size = board.length;
        this.board = board;
        if(!Arrays.stream(board).allMatch(row -> row.length == this.size)) throw new IllegalArgumentException("not quadratic.");
    }

    public boolean checkSudoku() {
//        boolean isvalid = true;
//        for (SudokuPart row : getRows()) {
//            isvalid &= row.isValid();
//        }
//        return isvalid;

        return StreamSupport.stream(getRows().spliterator(), true).allMatch(SudokuPart::isValid);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            int j = 0;

            @Override
            public boolean hasNext() {
                return i < size ;
            }

            @Override
            public Integer next() {
                int result = board[i][j];
                j++;
                if (j >= size) {
                    j = 0;
                    i++;
                }
                return result;
            }
        };
    }

    public Iterable<SudokuPart> getRows() {
        return () -> new Iterator<SudokuPart>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public SudokuPart next() {
                // Nehme i-te Zeile und verwandle sie in eine Collection.
                Collection<Integer> value = Arrays.stream(board[i]).boxed().collect(Collectors.toList());
                i++;
                return new SudokuPart(value);
            }
        };
    }




    public static void main(String[] args) {
        int[][] board = new int[][]{
                {8, 3, 5, 4, 1, 6, 9, 2, 7},
                {2, 9, 6, 8, 5, 7, 4, 3, 1},
                {4, 1, 7, 2, 9, 3, 6, 5, 8},
                {5, 6, 9, 1, 3, 4, 7, 8, 2},
                {1, 2, 3, 6, 7, 8, 5, 4, 9},
                {7, 4, 8, 5, 2, 9, 1, 6, 3},
                {6, 5, 2, 7, 8, 1, 3, 9, 4},
                {9, 8, 1, 3, 4, 5, 2, 7, 6},
                {3, 7, 4, 9, 6, 2, 8, 1, 5}};

        Sudoku sudoku = new Sudoku(board);

//        Iterator<Integer> iterator = sudoku.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        System.out.println(sudoku.checkSudoku());

    }
}
