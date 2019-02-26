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
    }catch(FileNotFoundException e){
      System.out.println("File not found");
    }
  }
}
