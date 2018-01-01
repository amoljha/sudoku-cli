import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Grid {

    private static class Open_Position{
        int x;
        int y;

        public Open_Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private Grid_Element Grid[][];
    private LinkedList<Open_Position> open_positions;

    public Grid(){
        this.Grid = new Grid_Element[9][9];     //A standard Sudoku Grid
        this.open_positions = new LinkedList<>();
        initialize_grid();
    }

    public void initialize_grid(){
        for(int i=0;i<Grid.length;i++)
            for(int j=0;j<Grid.length;j++)
                Grid[i][j] = new Grid_Element();
    }

    public void display_grid() {
        for (int i = 0; i < Grid.length; i++) {
            for (int j = 0; j < Grid.length; j++) {
                if (Grid[i][j].getValue() == 0) System.out.print("X");
                else System.out.print(Grid[i][j].getValue());
                if((j+1)%3 == 0) System.out.print(" ");
            }
            System.out.println();
            if((i+1)%3 == 0) System.out.println();
        }
    }

    public void parse_file(String filename) throws FileNotFoundException{
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        int i=0;
        int j=0;

        while(scanner.hasNext()){
          int next_int = scanner.nextInt();
          Grid[i][j++].setValue(next_int);
          if(next_int == 0) open_positions.add(new Open_Position(i,j-1));
          if(j>0 && j%9==0){
              i++;
              j=0;
          }
        }
    }


}
