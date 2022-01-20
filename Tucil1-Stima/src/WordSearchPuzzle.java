import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordSearchPuzzle {
    ArrayList<ArrayList<String>> alphabet;
    ArrayList<String> word;

    // Untuk membaca word search puzzle dari file teks
    WordSearchPuzzle(String fileName) throws FileNotFoundException{
        this.alphabet = new ArrayList<ArrayList<String>>();
        this.word = new ArrayList<String>();
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        
        while (scan.hasNextLine()) {
            String next = scan.nextLine();
            if (next.isEmpty()) { // membaca kunci jawaban (setelah line kosong)
                while (scan.hasNextLine()) {
                    this.word.add(scan.next());
                }
            } else { // membaca puzzle
                String[] a = next.split("\\s+");
                List <String> tmp2 = (List<String>) Arrays.asList(a);
                ArrayList<String> tmp = new ArrayList<String>(tmp2);
                this.alphabet.add(tmp);
            }         
        }
    }
}
