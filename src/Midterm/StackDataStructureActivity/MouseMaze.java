package Midterm.StackDataStructureActivity;

import java.util.Scanner;
import java.util.Stack;
/**
 * Sample Mouse Maze Puzzle.
 * The mouse(M) is positioned in a cell of the maze.
 * The mouse sequentially moves to open cells until the mouse reaches the exit cell E.
 * An open cell is marked by 0.
 * A closed cell is marked by 1.
 * by : <ENCARNACION, Ma. Earl Freskkie>
 */
public class MouseMaze {
    private int rows;
    private int cols;
    private MazeCell currentCell = null;
    private MazeCell exitCell = new MazeCell();
    private MazeCell entryCell = new MazeCell();
    private final char EXIT_MARKER = 'E';
    private final char ENTRY_MARKER = 'M';
    private final char VISITED = '-'; //Changed the character symbol
    private final char WALL = '1';
    private final char PASSAGE = '0';
    private Stack<MazeCell> mazeStack = new Stack<MazeCell>();
    private Scanner keyboard = new Scanner(System.in);

    private char[][] myMaze = {
            {WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, WALL, PASSAGE, PASSAGE, EXIT_MARKER, WALL},
            {WALL, PASSAGE, PASSAGE, WALL, WALL, WALL},
            {WALL, WALL, PASSAGE, PASSAGE, PASSAGE, WALL},
            {WALL, WALL, PASSAGE, PASSAGE, ENTRY_MARKER, WALL},
            {WALL, PASSAGE, WALL, WALL, WALL, WALL}
    };

    public MouseMaze() {
        boolean foundEntryCell = false;
        boolean foundExitCell = false;

        /**Look for the entry cell, the initial location of the mouse*/
        for (int row = 0; row < myMaze.length && !foundEntryCell; row++)
            for (int col = 0; col < myMaze[row].length && !foundEntryCell; col++) {
                if (myMaze[row][col] == 'M') {
                    entryCell.setRow(row);
                    entryCell.setColumn(col);
                    foundEntryCell = true;
                }
            }

        /**Look for the exit cell, the cell where the mouse may jump out of the maze*/
        for (int row = 0; row < myMaze.length && !foundExitCell; row++)
            for (int col = 0; col < myMaze[row].length && !foundExitCell; col++) {

                if (myMaze[row][col] == 'E') {
                    exitCell.setRow(row);
                    exitCell.setColumn(col);
                    foundExitCell = true;
                }
            }
        rows = myMaze.length;
        cols = myMaze[0].length;
    } //end of Maze constructor

    /**
     * Show the maze with the current path followed by the mouse if any
     */
    private void display(char[][] myMaze) {
        for (int row = 0; row < myMaze.length; row++) {
            for (int col = 0; col < myMaze[row].length; col++)
                System.out.print(myMaze[row][col]);
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Puts a cell with the given row and col index into a stack of cells to be visited
     * if the cell is marked as an open cell or exit cell
     */
    private void pushUnvisited(int row, int col) {
        if (myMaze[row][col] == PASSAGE || myMaze[row][col] == EXIT_MARKER)
            mazeStack.push(new MazeCell(row, col));
    }

    /**
     * Let the mouse finds its way to the exit cell
     */
    public void findWayOut() {
        int row = 0;
        int col = 0;
        //Start from the entry cell, the cell where the mouse is initially placed
        currentCell = entryCell;
        System.out.println();
        display(myMaze);
        System.out.println("The above figure shows a maze where a mouse M is in.");
        System.out.println("The Mouse M should move to exhaustively find the Exit cell E");
        System.out.println("A cell marked 0 is an open cell, a cell marked by 1 is a closed cell");
        System.out.println("Keep pressing the enter key until success or failure is reached.");
        System.out.println("Find the way out.");

        keyboard.nextLine();
        while (!currentCell.equals(exitCell)) {
            row = currentCell.getRow();
            col = currentCell.getColumn();
            if (currentCell.sameAs(exitCell)) {
                display(myMaze);
                System.out.println("Success! Exit found");
                break;
            }
            if (!currentCell.sameAs(entryCell)) {
                myMaze[row][col] = VISITED;
                display(myMaze);
                System.out.println("Find the way out.");
                keyboard.nextLine();
            }

            /**Create a Stack of the cells to be explored following the fixed order
             * up, down, left and right.
             * A cell is included in the cell to be explored only if the cell is an open cell.
             * The pushUnvisited method is written such that it will only put the cell in the Stack if
             * the cell is open */
            pushUnvisited(row - 1, col); // note if cell up is open
            pushUnvisited(row + 1, col); // note if cell down is open
            pushUnvisited(row, col - 1); // note if cell at left is open
            pushUnvisited(row, col + 1); // note if cell at right is open

            if (mazeStack.isEmpty()) {
                display(myMaze);
                System.out.println("Failure: Exit cannot be reached");
                return;
            } else {
                currentCell = mazeStack.pop(); //try to move to a reachable cell
            }
        }
    }

    /**
     * Main method of the program
     */
    public static void main(String[] args) {
        MouseMaze solver;
        try {
            solver = new MouseMaze();
            solver.findWayOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    } //end of main
}
