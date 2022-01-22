import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        WordSearchPuzzle x = new WordSearchPuzzle(filename);
        System.out.println(x.alphabet);
        System.out.println(x.word);
        
        x.fromLeftHorizontal();
        System.out.print("\n");
        x.fromRightHorizontal();
        System.out.print("\n");
        x.fromTopVertical();
        System.out.print("\n");
        x.fromBottomVertical();
    }
}
