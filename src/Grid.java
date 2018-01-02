import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    private ArrayList<Integer>[] columns;
    private ArrayList<Integer>[] rows;


    public Grid(){
        this.Grid = new Grid_Element[9][9];     //A standard Sudoku Grid
        this.open_positions = new LinkedList<>();
        initialize_grid();
        this.columns = new ArrayList[9];
        this.rows = new ArrayList[9];
        for(int i=0;i<9;i++) {
            columns[i] = new ArrayList<>(9);
            rows[i] = new ArrayList<>(9);
            for(int j=1;j<10;j++){
                columns[i].add(j);
                rows[i].add(j);
            }
        }
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
          else{
              columns[j-1].remove(Integer.valueOf(next_int));
              rows[i].remove(Integer.valueOf(next_int));
          }
          if(j>0 && j%9==0){
              i++;
              j=0;
          }
        }

        for(int k=0;k<9;k++){
            System.out.printf("Row: %d, open possibilities: ",k);
            for (int l:rows[k]) {
                System.out.printf("%d ",l);
            }
            System.out.println();
            System.out.printf("Column: %d, open possibilities: ",k);
            for (int l:columns[k]) {
                System.out.printf("%d ",l);
            }
            System.out.println();
        }
    }
}
