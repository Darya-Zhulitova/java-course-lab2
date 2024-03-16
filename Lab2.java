import java.io.*;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите имя входного файла: ");
            String inputFile = scanner.nextLine();
            System.out.print("Введите имя выходного файла: ");
            String outputFile = scanner.nextLine();

            BufferedReader fileReader;
            try {
                fileReader = new BufferedReader(new FileReader(inputFile));
            } catch (FileNotFoundException ex) {
                System.out.println("Ошибка: входной файл не найден.");
                return;
            }
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile));
            int[] arrayMin = new int[26];
            int[] arrayBig = new int[26];
            for (int i = 0; i < 26; i++) {
                arrayMin[i] = 0;
                arrayBig[i] = 0;
            }
            int character;
            character = fileReader.read();
            while (character != -1) {
                if ('a' <= character && character <= 'z') {
                    arrayMin[character - 'a'] = arrayMin[character - 'a'] + 1;
                } else if ('A' <= character && character <= 'Z') {
                    arrayBig[character - 'A'] = arrayBig[character - 'A'] + 1;
                }
                character = fileReader.read();
            }
            for (int i = 0; i < 26; i++) {
                fileWriter.write((char) (i + 'a') + ": " + arrayMin[i]);
                fileWriter.newLine();
            }
            for (int i = 0; i < 26; i++) {
                fileWriter.write((char) (i + 'A') + ": " + arrayBig[i]);
                fileWriter.newLine();
            }
            fileReader.close();
            fileWriter.close();
            System.out.println("Результаты подсчета символов записаны в выходной файл.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода/вывода: " + e.getMessage());
        }
    }
}
