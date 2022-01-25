import java.util.Scanner;
import java.lang.System;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama file (.txt): ");
        String filename = scanner.nextLine();
        WordSearchPuzzle x = new WordSearchPuzzle(filename);
        long startTime = System.nanoTime();
        x.solvePuzzle();
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total waktu eksekusi program: " + totalTime + " ns");
    }
}
