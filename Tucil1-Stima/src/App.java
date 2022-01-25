import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama file (.txt): ");
        String filename = scanner.nextLine();
        WordSearchPuzzle x = new WordSearchPuzzle(filename);
        
        x.solvePuzzle();
    }
}
