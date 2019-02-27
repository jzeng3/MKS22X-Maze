import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:
         throw a FileNotFoundException or IllegalStateException
    */
    public Maze(String filename) throws FileNotFoundException{
      File mazeFile = new File(filename);
      Scanner inf = new Scanner(mazeFile);
      String mazeString = "";
      while (inf.hasNextLine()){
        mazeString += inf.nextLine()+"\n";
      }
      int numS = 0;
      int numE = 0;
      int numRows = 0;
      for (int i = 0; i < mazeString.length(); i++){
        if (mazeString.charAt(i) == 'E'){
          numE++;
        }
        if (mazeString.charAt(i) == 'S'){
          numS++;
        }
        if (mazeString.charAt(i) == '\n'){
          numRows++;
        }
      }
      if (numS != 1 || numE != 1){
        throw new IllegalStateException();
      }
      int numCols = mazeString.length()/ numRows;
      maze = new char[numRows][numCols];
      System.out.println("MAZE SIZE: "+ numRows +" X "+numCols);
      int index = 0;
      for (int r = 0; r < numRows; r++){
        for (int c = 0; c < numCols; c++){
          maze[r][c] = mazeString.charAt(index);
          index++;

        }
      }
      setAnimate(false);
        //COMPLETE CONSTRUCTOR
    }

    public String toString(){
      String mazeStr = "";
      for (int r = 0; r < maze.length; r++){
        for (int c = 0; c < maze[0].length; c++){
          mazeStr += maze[r][c];
        }
      }
      return mazeStr;
    }

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
            //find the location of the S.
        int rowS = 0;
        int colS = 0;
        for (int r = 0; r < maze.length; r++){
          for (int c = 0; c < maze[0].length; c++){
            if (maze[r][c] == 'S'){
              rowS = r;
              colS = c;
              c = maze[0].length;
              r = maze.length;
            }
          }
        }
            //erase the S
            System.out.println(rowS+" "+colS);
            //and start solving at the location of the s.
            return solve(rowS, colS, 1);

    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int step){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }
        char current = maze[row][col];
        // base case: stop if end is reached
        if (current == 'E'){
          return step;
        }
        else{
          // if spot can be visited
          if (current == 'S' || current == ' '){
            maze[row][col] = '@';
            return solve(row,col+1, step+1);
          }
        }
        //COMPLETE SOLVE
        return -1; //so it compiles
    }

}
