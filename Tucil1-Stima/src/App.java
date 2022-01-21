import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        WordSearchPuzzle x = new WordSearchPuzzle(filename);
        System.out.println(x.alphabet);
        System.out.println(x.word);
        x.fromLeftHorizontal();
        System.out.println(x.alphabet.get(0).get(2).length());
        System.out.println(String.valueOf(x.word.get(0).charAt(1)).length());
    }
}
