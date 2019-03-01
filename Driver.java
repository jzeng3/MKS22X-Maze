import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args){
      String filename = "";
      if (args.length == 0){
        filename = "data1.dat";
      }
      else{
        filename = args[0];
      }

      try{
        Maze f;
        f = new Maze(filename);//true animates the maze.
        f.setAnimate(true);
        System.out.println("NUMBER OF STEPS: "+ f.solve());
        System.out.println(f);
      }catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+filename);
      }
    }
}
