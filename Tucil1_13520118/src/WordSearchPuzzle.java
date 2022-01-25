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

    // Pencarian horizontal dari kiri

    public void fromLeftHorizontal() {
        for (int j = 0; j < this.word.size(); j ++) { // loop untuk tiap kata dalam kunci jawaban
            int lettersCompared = 0;
            int wordLength = this.word.get(j).length();
            for (int i = 0; i < this.alphabet.size(); i ++) { // loop untuk tiap baris matriks
                boolean found = false;
                int textLength = this.alphabet.get(i).size();
                int k = 0;
                while (k <= (textLength - wordLength) && !found) { // loop dalam pemeriksaan karakter
                    int l = 0;
                    while ((l < wordLength) && (this.alphabet.get(i).get(k + l).equals(String.valueOf(this.word.get(j).charAt(l))))) { // loop dalam pemeriksaan karakter
                        lettersCompared ++;
                        l ++;
                    }
                    if (l == wordLength) {
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
                        System.out.println("Jumlah komparasi huruf: " + (lettersCompared));
                        System.out.println("\n");
                        found = true;
                    } else {
                        lettersCompared ++;
                        k ++;
                    }
                }
            }
        }
    }

    // Pencarian horizontal dari kanan

    public void fromRightHorizontal() {
        for (int j = 0; j < this.word.size(); j ++) { // loop untuk tiap kata dalam kunci jawaban
            int lettersCompared = 0;
            for (int i = 0; i < this.alphabet.size(); i ++) { // loop untuk tiap baris matriks
                boolean found = false;
                int textLength = this.alphabet.get(i).size();
                int wordLength = this.word.get(j).length();
                int k = textLength - 1;
                while (k >= (wordLength - 1) && !found) { // loop dalam pemeriksaan karakter
                    int l = 0;
                    while ((l < wordLength) && (this.alphabet.get(i).get(k-l).equals(String.valueOf(this.word.get(j).charAt(l))))) { // loop dalam pemeriksaan karakter
                        lettersCompared ++;
                        l ++;
                    }
                    if (l == wordLength) {
                        int printed = k+1-l;
                        for (int row = 0; row < this.alphabet.size(); row ++) {
                            for (int col = 0; col < this.alphabet.get(0).size(); col ++) {
                                if (row == i && col >= printed && col <= printed + wordLength - 1) {
                                    System.out.print(this.alphabet.get(row).get(col) + " ");
                                } else {
                                    System.out.print("- ");
                                }
                            }
                            System.out.print("\n");
                        }
                        System.out.println("Jumlah komparasi huruf: " + (lettersCompared));
                        System.out.println("\n");
                        found = true;
                    } else {
                        lettersCompared ++;
                        k --;
                    }
                }
            }
        }
    }

    // Pencarian vertical dari atas

    public void fromTopVertical() {
        for (int j = 0; j < this.word.size(); j ++) { // loop untuk tiap kata dalam kunci jawaban
            int lettersCompared = 0;
            int wordLength = this.word.get(j).length();
            for (int i = 0; i < this.alphabet.get(0).size(); i ++) { // loop untuk tiap kolom matriks
                boolean found = false;
                int textLength = this.alphabet.size();
                int k = 0;
                while (k <= (textLength - wordLength) && !found) { // loop dalam pemeriksaan karakter
                    int l = 0;
                    while ((l < wordLength) && (this.alphabet.get(k + l).get(i).equals(String.valueOf(this.word.get(j).charAt(l))))) { // loop dalam pemeriksaan karakter
                        lettersCompared ++;
                        l ++;
                    }
                    if (l == wordLength) {
                        int printed = k + wordLength - 1;
                        for (int row = 0; row < this.alphabet.size(); row ++) {
                            for (int col = 0; col < this.alphabet.get(0).size(); col ++) {
                                if (col == i && row >= k && row <= printed) {
                                    System.out.print(this.alphabet.get(row).get(col) + " ");
                                } else {
                                    System.out.print("- ");
                                }
                            }
                            System.out.print("\n");
                        }
                        System.out.println("Jumlah komparasi huruf: " + (lettersCompared));
                        System.out.println("\n");
                        found = true;
                    } else {
                        lettersCompared ++;
                        k ++;
                    }
                }
            }
        }
    }

    // Pencarian vertical dari bawah

    public void fromBottomVertical() {
        for (int j = 0; j < this.word.size(); j ++) { // loop untuk tiap kata dalam kunci jawaban
            int lettersCompared = 0;
            int wordLength = this.word.get(j).length();
            for (int i = 0; i < this.alphabet.get(0).size(); i ++) { // loop untuk tiap kolom matriks
                boolean found = false;
                int textLength = this.alphabet.size();
                int k = textLength - 1;
                while (k >= (wordLength - 1) && !found) { // loop dalam pemeriksaan karakter
                    int l = 0;
                    while ((l < wordLength) && (this.alphabet.get(k - l).get(i).equals(String.valueOf(this.word.get(j).charAt(l))))) { // loop dalam pemeriksaan karakter
                        lettersCompared ++;
                        l ++;
                    }
                    if (l == wordLength) {
                        int printed = k+1-l;
                        for (int row = 0; row < this.alphabet.size(); row ++) {
                            for (int col = 0; col < this.alphabet.get(0).size(); col ++) {
                                if (col == i && row >= printed && row <= printed + wordLength - 1) {
                                    System.out.print(this.alphabet.get(row).get(col) + " ");
                                } else {
                                    System.out.print("- ");
                                }
                            }
                            System.out.print("\n");
                        }
                        System.out.println("Jumlah komparasi huruf: " + (lettersCompared));
                        System.out.println("\n");
                        found = true;
                    } else {
                        lettersCompared ++;
                        k --;
                    }
                }
            }
        }
    }

    // pencarian dari atas kiri secara diagonal 

    public void fromLeftTopDiagonal() {
        for (int j = 0; j < this.word.size(); j ++) { // loop untuk tiap kata dalam kunci jawaban
            int lettersCompared = 0;
            int wordLength = this.word.get(j).length();
            for (int i = 0; i < this.alphabet.size(); i ++) { // loop tiap baris puzzle
                if (i == 0) {
                    for (int for_row_0 = 0; for_row_0 < this.alphabet.get(0).size(); for_row_0 ++) { // khusus baris pertama akan diloop untuk tiap kolomnya
                        int kol = for_row_0;
                        boolean found = false;
                        int ct_row = i;
                        int ct_col = kol;
                        int textLength = 0;
                        while (ct_row <= this.alphabet.size() && ct_col <= this.alphabet.get(0).size()) {
                            textLength ++;
                            ct_row ++;
                            ct_col ++;
                        }
                        int k = i;
                        while (k <= textLength - wordLength && !found) {
                            int l = 0;
                            while (l < wordLength && (this.alphabet.get(k + l).get(kol + l).equals(String.valueOf(this.word.get(j).charAt(l))))) {
                                lettersCompared ++;
                                l ++;
                            }
                            if (l == wordLength) { // match pada baris k dan kolom kol
                                int row_printed = k;
                                int col_printed = kol;
                                for (int row = 0; row < this.alphabet.size(); row ++) {
                                    for (int col = 0; col < this.alphabet.get(0).size(); col ++) {
                                        if (row == row_printed && col == col_printed) {
                                            System.out.print(this.alphabet.get(row).get(col) + " ");
                                            if (col_printed < kol + wordLength - 1 && row_printed < k + wordLength - 1) {
                                                row_printed ++;
                                                col_printed ++;
                                            }
                                        } else {
                                            System.out.print("- ");
                                        }
                                    }
                                    System.out.print("\n");  
                                }
                                System.out.println("Jumlah komparasi huruf: " + (lettersCompared));
                                System.out.println("\n");
                                found = true;
                            } else {
                                lettersCompared ++;
                                k ++;
                                kol ++;
                            }
                        }
                    }
                } else {
                    int kol = 0;
                    boolean found = false;
                    int ct_row = i;
                    int ct_col = kol;
                    int textLength = 0;
                    while (ct_row <= this.alphabet.size() && ct_col <= this.alphabet.get(0).size()) {
                        textLength ++;
                        ct_row ++;
                        ct_col ++;
                    }
                    int k = i;
                    while (kol <= textLength - wordLength && !found) {
                        int l = 0;
                        while (l < wordLength && (this.alphabet.get(k + l).get(kol + l).equals(String.valueOf(this.word.get(j).charAt(l))))) {
                            lettersCompared ++;
                            l ++;
                        }
                        if (l == wordLength) { // match pada baris k dan kolom kol
                            int row_printed = k;
                            int col_printed = kol;
                            for (int row = 0; row < this.alphabet.size(); row ++) {
                                for (int col = 0; col < this.alphabet.get(0).size(); col ++) {
                                    if (row == row_printed && col == col_printed) {
                                        System.out.print(this.alphabet.get(row).get(col) + " ");
                                        if (col_printed < kol + wordLength - 1 && row_printed < k + wordLength - 1) {
                                            row_printed ++;
                                            col_printed ++;
                                        }
                                    } else {
                                        System.out.print("- ");
                                    }
                                }
                                System.out.print("\n");  
                            }
                            System.out.println("Jumlah komparasi huruf: " + (lettersCompared));
                            System.out.println("\n");
                            found = true;
                        } else {
                            lettersCompared ++;
                            k ++;
                            kol ++;
                        }
                    }
                }
            }   
        }
    } 

    // pencarian dari atas kanan secara diagonal

    public void fromRightTopDiagonal() {
        for (int j = 0; j < this.word.size(); j ++) { // loop untuk tiap kata dalam kunci jawaban
            int lettersCompared = 0;
            int wordLength = this.word.get(j).length();
            for (int i = 0; i < this.alphabet.size(); i ++) { // loop tiap baris puzzle
                if (i == 0) { // khusus baris pertama akan diloop untuk tiap kolomnya
                    for (int for_row_0 = this.alphabet.get(0).size() - 1; for_row_0 >= 0; for_row_0 --) {
                        int kol = for_row_0;
                        boolean found = false;
                        int textLength = this.alphabet.size() - kol; 
                        int k = i;
                        while (kol >= wordLength - 1 && !found) {
                            int l = 0;
                            while (l < wordLength && (this.alphabet.get(k + l).get(kol - l).equals(String.valueOf(this.word.get(j).charAt(l))))) {
                                lettersCompared ++;
                                l ++;
                            }
                            if (l == wordLength) { // match pada baris k dan kolom kol
                                int row_printed = k;
                                int col_printed = kol;
                                for (int row = 0; row < this.alphabet.size(); row ++) {
                                    for (int col = 0; col < this.alphabet.get(0).size(); col ++) {
                                        if (row == row_printed && col == col_printed) {
                                            System.out.print(this.alphabet.get(row).get(col) + " ");
                                            if (col_printed > kol - wordLength + 1 && row_printed < k + wordLength - 1) {
                                                row_printed ++;
                                                col_printed --;
                                            }
                                        } else {
                                            System.out.print("- ");
                                        }
                                    }
                                    System.out.print("\n");  
                                }
                                System.out.println("Jumlah komparasi huruf: " + (lettersCompared));
                                System.out.println("\n");
                                found = true;
                            } else {
                                lettersCompared ++;
                                k ++;
                                kol --;
                            }
                        }
                    }
                } else {
                    int kol = this.alphabet.get(0).size() - 1;
                    boolean found = false;
                    int ct_row = i;
                    int ct_col = kol;
                    int textLength = 0;
                    while (ct_row <= this.alphabet.size() && ct_col >= 0) {
                        textLength ++;
                        ct_row ++;
                        ct_col --;
                    }
                    int k = i;
                    while (k <= textLength - wordLength && !found) {
                        int l = 0;
                        while (l < wordLength && (this.alphabet.get(k + l).get(kol - l).equals(String.valueOf(this.word.get(j).charAt(l))))) {
                            lettersCompared ++;
                            l ++;
                        }
                        if (l == wordLength) { // match pada baris k dan kolom kol
                            int row_printed = k;
                            int col_printed = kol;
                            for (int row = 0; row < this.alphabet.size(); row ++) {
                                for (int col = 0; col < this.alphabet.get(0).size(); col ++) {
                                    if (row == row_printed && col == col_printed) {
                                        System.out.print(this.alphabet.get(row).get(col) + " ");
                                        if (col_printed > kol - wordLength + 1 && row_printed < k + wordLength - 1) {
                                            row_printed ++;
                                            col_printed --;
                                        }
                                    } else {
                                        System.out.print("- ");
                                    }
                                }
                                System.out.print("\n");  
                            }
                            System.out.println("Jumlah komparasi huruf: " + (lettersCompared));
                            System.out.println("\n");
                            found = true;
                        } else {
                            lettersCompared ++;
                            k ++;
                            kol --;
                        }
                    }
                }
            }   
        }
    }

    // pencarian dari bawah kiri secara diagonal

    public void fromLeftBottomDiagonal() {
        for (int j = 0; j < this.word.size(); j ++) {
            int lettersCompared = 0;
            int wordLength = this.word.get(j).length();
            for (int i = this.alphabet.size() - 1; i >= 0; i --) { // loop tiap baris puzzle
                if (i == this.alphabet.size() - 1) { 
                    for (int for_last_row = 0; for_last_row < this.alphabet.get(0).size(); for_last_row ++) { // khusus baris terakhir akan diloop untuk tiap kolomnya
                        // loop untuk tiap kata dalam kunci jawaban
                            int kol = for_last_row;
                            boolean found = false;
                            int ct_row = i;
                            int ct_col = kol;
                            int textLength = 0;
                            while (ct_row >= 0 && ct_col <= this.alphabet.get(0).size()) {
                                textLength ++;
                                ct_row --;
                                ct_col ++;
                            }
                            int k = i;
                            while (kol <= ct_col - wordLength && !found) {
                                int l = 0;
                                while (l < wordLength && (this.alphabet.get(k - l).get(kol + l).equals(String.valueOf(this.word.get(j).charAt(l))))) {
                                    lettersCompared ++;
                                    l ++;
                                }
                                if (l == wordLength) { // match pada baris k dan kolom kol
                                    int row_printed = k - wordLength + 1;
                                    int col_printed = kol + wordLength - 1;
                                    for (int row = 0; row < this.alphabet.size(); row ++) {
                                        for (int col = 0; col < this.alphabet.get(0).size(); col ++) {
                                            if (row == row_printed && col == col_printed) {
                                                System.out.print(this.alphabet.get(row).get(col) + " ");
                                                if (col_printed > kol && row_printed < k) {
                                                    row_printed ++;
                                                    col_printed --;
                                                }
                                            } else {
                                                System.out.print("- ");
                                            }
                                        }
                                        System.out.print("\n");  
                                    }
                                    System.out.println("Jumlah komparasi huruf: " + (lettersCompared));
                                    System.out.println("\n");
                                    found = true;
                                } else {
                                    lettersCompared ++;
                                    k --;
                                    kol ++;
                                }
                            }
                    }
                } else {
                    int kol = 0;
                    boolean found = false;
                    int ct_row = i;
                    int ct_col = kol;
                    int textLength = 0;
                    while (ct_row >= 0 && ct_col <= this.alphabet.get(0).size()) {
                        textLength ++;
                        ct_row --;
                        ct_col ++;
                    } 
                    int k = i;
                    while (kol <= ct_col - wordLength && !found) {
                        int l = 0;
                        while (l < wordLength && (this.alphabet.get(k - l).get(kol + l).equals(String.valueOf(this.word.get(j).charAt(l))))) {
                            lettersCompared ++;
                            l ++;
                        }
                        if (l == wordLength) { // match pada baris k dan kolom kol
                            int row_printed = k - wordLength + 1;
                            int col_printed = kol + wordLength - 1;
                            for (int row = 0; row < this.alphabet.size(); row ++) {
                                for (int col = 0; col < this.alphabet.get(0).size(); col ++) {
                                    if (row == row_printed && col == col_printed) {
                                        System.out.print(this.alphabet.get(row).get(col) + " ");
                                        if (col_printed > kol && row_printed < k) {
                                            row_printed ++;
                                            col_printed --;
                                        }
                                    } else {
                                        System.out.print("- ");
                                    }
                                }
                                System.out.print("\n");  
                            }
                            System.out.println("Jumlah komparasi huruf: " + (lettersCompared));
                            System.out.println("\n");
                            found = true;
                        } else {
                            lettersCompared ++;
                            k --;
                            kol ++;
                        }
                    }
                }   
            }
        }
    }  
    
    public void fromRightBottomDiagonal() {
        for (int j = 0; j < this.word.size(); j ++) { // loop untuk tiap kata dalam kunci jawaban
            int lettersCompared = 0;
            int wordLength = this.word.get(j).length();
            for (int i = this.alphabet.size() - 1; i >= 0; i --) { // loop tiap baris puzzle
                if (i == this.alphabet.size() - 1) { // khusus baris terakhir akan diloop untuk tiap kolomnya
                    for (int for_last_row = 0; for_last_row < this.alphabet.get(0).size(); for_last_row ++) {
                        int kol = for_last_row;
                        boolean found = false;
                        int ct_row = i;
                        int ct_col = kol;
                        int textLength = 0;
                        while (ct_row >= 0 && ct_col >= 0) {
                            textLength ++;
                            ct_row --;
                            ct_col --;
                        } 
                        int k = i;
                        while (kol >= wordLength - 1 && !found) {
                            int l = 0;
                            while (l < wordLength && (this.alphabet.get(k - l).get(kol - l).equals(String.valueOf(this.word.get(j).charAt(l))))) {
                                lettersCompared ++;
                                l ++;
                            }
                            if (l == wordLength) { // match pada baris k dan kolom kol
                                int row_printed = k - wordLength + 1;
                                int col_printed = kol - wordLength + 1;
                                for (int row = 0; row < this.alphabet.size(); row ++) {
                                    for (int col = 0; col < this.alphabet.get(0).size(); col ++) {
                                        if (row == row_printed && col == col_printed) {
                                            System.out.print(this.alphabet.get(row).get(col) + " ");
                                            if (col_printed < kol && row_printed < k) {
                                                row_printed ++;
                                                col_printed ++;
                                            }
                                        } else {
                                            System.out.print("- ");
                                        }
                                    }
                                    System.out.print("\n");  
                                }
                                System.out.println("Jumlah komparasi huruf: " + (lettersCompared));
                                System.out.println("\n");
                                found = true;
                            } else {
                                lettersCompared ++;
                                k --;
                                kol --;
                            }
                        }
                    }
                } else {
                    int kol = this.alphabet.get(0).size() - 1;
                    boolean found = false;
                    int ct_row = i;
                    int ct_col = kol;
                    int textLength = 0;
                    while (ct_row >= 0 && ct_col >= 0) {
                        textLength ++;
                        ct_row --;
                        ct_col --;
                    }
                    int k = i;
                    while (k >= wordLength - 1 && !found) {
                        int l = 0;
                        while (l < wordLength && (this.alphabet.get(k - l).get(kol - l).equals(String.valueOf(this.word.get(j).charAt(l))))) {
                            lettersCompared ++;
                            l ++;
                        }
                        if (l == wordLength) { // match pada baris k dan kolom kol
                            int row_printed = k - wordLength + 1;
                            int col_printed = kol - wordLength + 1;
                            for (int row = 0; row < this.alphabet.size(); row ++) {
                                for (int col = 0; col < this.alphabet.get(0).size(); col ++) {
                                    if (row == row_printed && col == col_printed) {
                                        System.out.print(this.alphabet.get(row).get(col) + " ");
                                        if (col_printed < kol && row_printed < k) {
                                            row_printed ++;
                                            col_printed ++;
                                        }
                                    } else {
                                        System.out.print("- ");
                                    }
                                }
                                System.out.print("\n");  
                            }
                            System.out.println("Jumlah komparasi huruf: " + (lettersCompared));
                            System.out.println("\n");
                            found = true;
                        } else {
                            lettersCompared ++;
                            k --;
                            kol --;
                        }
                    }
                }   
            }
        }
    }
    
    public void solvePuzzle() {
        System.out.println("Berikut adalah solusi dari puzzle yang disubmit: ");
        fromLeftHorizontal();
        System.out.print("\n");
        fromRightHorizontal();
        System.out.print("\n");
        fromTopVertical();
        System.out.print("\n");
        fromBottomVertical();
        System.out.print("\n");
        fromLeftTopDiagonal();
        System.out.print("\n");
        fromRightTopDiagonal();
        System.out.print("\n");
        fromLeftBottomDiagonal();
        System.out.println("\n");
        fromRightBottomDiagonal();
        System.out.println("\n");
    }
}