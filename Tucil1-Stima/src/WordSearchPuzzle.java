import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordSearchPuzzle {
    ArrayList<ArrayList<String>> alphabet;
    ArrayList<String> word;
    // isi dari matriks. cara mengakses matriks Matrix.Content[row][col]
    // indeks (row) baris dan (col) dimulai dari 0;

    // Untuk membaca word search puzzle dari file teks
    WordSearchPuzzle(String fileName) throws FileNotFoundException{
        ArrayList<ArrayList<String>> alphabet = new ArrayList<ArrayList<String>>();
        File file = new File(fileName);
        Scanner scan = new Scanner(file);

        String newLine = System.getProperty("line.separator");

        while (scan.hasNextLine()) {
            String[] a = scan.nextLine().split("\\s+");
            List <String> tmp2 = (List<String>) Arrays.asList(a);
            ArrayList<String> tmp = new ArrayList<String>(tmp2);
            alphabet.add(tmp);
        }
        System.out.println(alphabet);
        // if (row == 0) {
        //     System.out.println("Tidak ada data dalam file " + fileName);
        // } else {
        //     col = Content.get(0).size();
        //     this.Content = new double[row][col];
        //     this.RowEff = row;
        //     this.ColEff = col;
        //     for (int i = 0; i < row; i ++) {
        //         for (int j = 0; j < col; j ++) {
        //             this.Content[i][j] = Content.get(i).get(j);
        //         }
        //     }
        // }
    }
}
