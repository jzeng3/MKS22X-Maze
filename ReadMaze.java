import java.io.*;
import java.util.*;

public class ReadMaze{
  public static void main(String[] args){
    try{
      // read maze file and print each line
      File maze = new File("Maze1.txt");
      Scanner in = new Scanner(maze);
      while (in.hasNextLine()){
        String line = in.nextLine();
        System.out.println(line);
      }

      File maze_ = new File("Maze1.txt");
      Scanner inf = new Scanner(maze_);
      char[] array = new char[315];
      while (inf.hasNextLine()){
        String line = inf.nextLine();
        // add the characters of each line to array
        // print each element in the array
        // print newline at the end of the line
        for (int i = 0; i < line.length(); i++){
          array[i] = line.charAt(i);
          System.out.print(array[i]);
          if (i == line.length() -1){
            System.out.println();
          }
        }
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found");
    }
  }
}
