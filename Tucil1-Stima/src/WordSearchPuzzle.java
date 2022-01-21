import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordSearchPuzzle {
    ArrayList<ArrayList<String>> alphabet;
    ArrayList<String> word;

    // Konstruktor, membaca word search puzzle dari file teks
    WordSearchPuzzle(String fileName) throws FileNotFoundException {
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

    // Pencarian horizontal 

    public void fromLeftHorizontal() {
        for (int i = 0; i < this.alphabet.size(); i ++) { // loop untuk tiap baris matriks
            boolean found = false;
            int textLength = this.alphabet.get(i).size();
            for (int j = 0; j < this.word.size(); j ++) { // loop untuk tiap kata dalam kunci jawaban
                int wordLength = this.word.get(j).length();
                int k = 0;
                while (k <= (textLength - wordLength) && !found) { // loop dalam pemeriksaan karakter
                    int l = 0;
                    while ((l < wordLength) && (this.alphabet.get(i).get(k + l).equals(String.valueOf(this.word.get(j).charAt(l))))) { // loop dalam pemeriksaan karakter
                        l ++;
                        System.out.println("tes");
                    }
                    if (l == wordLength) {
                        System.out.println(k);
                        int printed = k + wordLength - 1;
                        for (int row = 0; row < this.alphabet.size(); row ++) {
                            for (int col = 0; col < this.alphabet.get(0).size(); col ++) {
                                if (row == i && col >= k && col <= printed) {
                                    System.out.print(this.alphabet.get(row).get(col) + " ");
                                } else {
                                    System.out.print("- ");
                                }
                            }
                            System.out.print("\n");
                        }
                        found = true;
                    } else {
                        k ++;
                    }
                }
            }
        }
    }
}
