import java.io.FileNotFoundException;

public class sudoku_solver_driver {
    public static void main(String[] args) throws FileNotFoundException {
        Grid grid = new Grid();
        grid.parse_file("sudoku_easy.txt");
        grid.display_grid();
    }
}
