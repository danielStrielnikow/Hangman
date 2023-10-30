import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Engineer {
    private final String filePath;
    private char[] userWord;
    private int lives = 5;
    private String randomWord;
    Scanner scanner = new Scanner(System.in);

    public Engineer(String filePath) {
        this.filePath = filePath;
    }

    // Otworzenie pliku i wylosowanie słowa
    public void playGame() {
        Path path = Paths.get(filePath);
        try {
            List<String> lines = Files.readAllLines(path);
            Random random = new Random();
            int randomIndex = random.nextInt(lines.size()); // Losowy indeks
            randomWord = lines.get(randomIndex); // Losowe słowo

            // Stworzenie '_' w takiej samej ilości co długość słowa
            userWord = new char[randomWord.length()];
            Arrays.fill(userWord, '_');

            while (!gameEnded()) {
                System.out.println(userWord);
                System.out.println();
                System.out.println("Podaj kolejną litere");
                System.out.println("Pozostało żyć " + lives);

                char letter = scanner.nextLine().charAt(0);

                checkLetter(letter);
            }


        } catch (IOException e) {
            System.out.println("Plik nie został znaleziony");
        }finally {
            scanner.close(); // Zamykanie scannera
        }
    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;
        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == letter) {
                userWord[i] = letter;
                foundLetter = true;
            }
        }
        if (!foundLetter) {
            System.out.println("Niestety nie ma takiej litery :(");
            lives--;
        }
    }

    private boolean gameEnded() {
        System.out.println("Przegrałeś");
        return lives == 0 || randomWord.equals(String.valueOf(userWord));
    }

}
